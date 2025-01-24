class Main {
 public static void main (String args[]){
     Mother m = new Mother ( );
     m.show( ); // show of Mother is called
     Child ch = new Child ( ); 
     ch.show ( ); // show ( ) inherited in Child from Mother is called
 }
}
