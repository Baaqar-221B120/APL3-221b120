public interface Flyable {
    default void fly(){
        System.out.println("Flying 🪽!"); // since most can fly
    } 
}
