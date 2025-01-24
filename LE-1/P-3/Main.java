class Main {
 public static void main (String args[]){
     Mother m = new Mother ( );
     m.show(); // Mother attr
     Child ch = new Child ( ); 
     ch.show (); // Child attr
     Mother m1 = new Child ( ); 
     m1.show(); // Child attr ; changes to Mother attr when both overridden and overiding function are static
 }
}
