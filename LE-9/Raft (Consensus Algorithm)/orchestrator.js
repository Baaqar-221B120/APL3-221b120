// orchestrator.js
// Option 1: send all Raft node logs to file, keep console free for CLI commands

const { spawn } = require('child_process');
const fs = require('fs');
const path = require('path');
const readline = require('readline');

// Configuration
const NODE_PORTS = [3000, 3001, 3002];
const LOG_FILE = path.join(__dirname, 'raft_log.txt');

// State
const procs = {};            // port -> ChildProcess
const nodeRoles = {};        // port -> last known role
NODE_PORTS.forEach(p => nodeRoles[p] = 'unknown');

// Initialize log file (overwrite existing)
fs.writeFileSync(LOG_FILE, '== RAFT MANUAL CONTROL SESSION START ==\n\n');

// Spawn a Raft node as child process and redirect its output to log file
function spawnNode(port) {
  const fellows = NODE_PORTS.filter(p => p !== port).join(',');
  fs.appendFileSync(LOG_FILE, `Spawning node ${port} (fellows: ${fellows})\n`);

  const child = spawn('node', ['test.js', `--port=${port}`, `--fellows=${fellows}`], {
    cwd: __dirname,
    stdio: ['ignore', 'pipe', 'pipe']
  });
  procs[port] = child;

  // Redirect stdout to log file
  child.stdout.on('data', chunk => {
    fs.appendFileSync(LOG_FILE, `[node ${port}] ${chunk.toString()}`);
    const line = chunk.toString();
    const m = line.match(/Role Transition:\s*(\w+)/i);
    if (m) nodeRoles[port] = m[1].toLowerCase();
  });

  // Redirect stderr to log file
  child.stderr.on('data', chunk => {
    fs.appendFileSync(LOG_FILE, `[node ${port}][ERR] ${chunk.toString()}`);
  });

  child.on('exit', (code, signal) => {
    fs.appendFileSync(LOG_FILE, `Node ${port} exited (code=${code}, signal=${signal})\n`);
    delete procs[port];
  });
}

// CLI for manual control
const rl = readline.createInterface({ input: process.stdin, output: process.stdout, prompt: '> ' });

function printStatus() {
  console.log('\nNode Status:');
  NODE_PORTS.forEach(port => {
    const alive = procs[port] ? 'running' : 'stopped';
    const role = nodeRoles[port] || 'unknown';
    console.log(`  ${port}: ${alive}, role=${role}`);
  });
  console.log('Logs are in raft_log.txt');
}

function printHelp() {
  console.log(`\nCommands:
  status             Show node status and roles
  kill <port>        Send SIGINT to node on <port>
  respawn <port>     Spawn node on <port> if not running
  killall            Kill all nodes
  respawnall         Spawn all nodes that are not running
  help               Show this help
  exit               Kill all and exit\n`);
}

// Handle commands
rl.prompt();
rl.on('line', line => {
  const [cmd, arg] = line.trim().split(/\s+/);
  switch (cmd) {
    case 'status':
      printStatus();
      break;

    case 'kill': {
      const port = Number(arg);
      if (procs[port]) {
        console.log(`Sending SIGINT to node ${port}`);
        procs[port].kill('SIGINT');
      } else console.log(`Node ${port} is not running.`);
      break;
    }

    case 'respawn': {
      const port = Number(arg);
      if (!procs[port]) spawnNode(port);
      else console.log(`Node ${port} is already running.`);
      break;
    }

    case 'killall':
      NODE_PORTS.forEach(p => {
        if (procs[p]) {
          console.log(`Killing node ${p}`);
          procs[p].kill('SIGINT');
        }
      });
      break;

    case 'respawnall':
      NODE_PORTS.forEach(p => { if (!procs[p]) spawnNode(p); });
      break;

    case 'help':
      printHelp();
      break;

    case 'exit':
      console.log('Exiting: killing all nodes');
      NODE_PORTS.forEach(p => { if (procs[p]) procs[p].kill('SIGINT'); });
      process.exit(0);
      break;

    default:
      console.log(`Unknown command: ${cmd}`);
      printHelp();
  }
  rl.prompt();
});

// Initial spawn of all nodes
NODE_PORTS.forEach(spawnNode);
console.log('RAFT manual control running. Type "help" for commands.');
