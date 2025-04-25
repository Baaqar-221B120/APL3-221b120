public class Application {
    public static void main(String[] args) {
        Swan swan = new LakeSwan();
        System.out.println("Princess meets a real swan.");
        client(swan);

        System.out.println("Princess meets a real crow.");
        Crow crow = new ForestCrow();
        try {
            client((Swan) crow); // to convert Runtime error to Compile error
        } catch (ClassCastException e) {
            System.out.println("Real crow ignored!");
        }

        System.out.println("Princess meets an imposter crow.");
        CrowAdapter crowadp = new CrowAdapter(crow);
        client(crowadp);
    }

    public static void client(Swan swan) {
        swan.eat();
        swan.swim();
        swan.sing();
    }
}
