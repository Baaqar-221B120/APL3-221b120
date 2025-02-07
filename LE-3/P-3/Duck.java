public interface Duck {
    default void swim(){
        System.out.println("I can swim!");
    } 
    void fly();
    void quack();
}
