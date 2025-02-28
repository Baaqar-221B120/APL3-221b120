public class Main {
    public static void main(String[] args) {
        // Test Lazy Singleton in Multithreading
        Runnable task = () -> {
            Singleton lazyInstance = Singleton.getIns();
            System.out.println("Lazy Singleton Instance: " + lazyInstance);
        };
        
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
