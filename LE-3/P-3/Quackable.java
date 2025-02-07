public interface Quackable {
    default void quack(){
        System.out.println("Quackk!"); // since most ducks quack
    } 
}
