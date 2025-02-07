public class Main{
   public static void main(String[] args) {
       System.out.println("Rubber Ducks:");
        RubberDucks rd = new RubberDucks();
        rd.swim();
        rd.fly();
        rd.quack();
        
        System.out.println("Wooden Ducks:");
        WoodenDucks wd = new WoodenDucks();
        wd.swim();
        wd.fly();
        wd.quack();
        
        System.out.println("RedHead Ducks:");
        RedHeadDucks rhd = new RedHeadDucks();
        rhd.swim();
        rhd.fly();
        rhd.quack();
        
        System.out.println("Lake Ducks:");
        LakeDucks ld = new LakeDucks();
        ld.swim();
        ld.fly();
        ld.quack();
    }
}
