class Main {
 public static void main (String args[]){
    One o = new One(10);
    Two t = new Two(10);
    /*
    Two.java:1: error: constructor One in class One cannot be applied to given types;
    class Two extends One { }
     ^
      required: int
      found: no arguments
      reason: actual and formal argument lists differ in length
      1 error
      */
 }
}
