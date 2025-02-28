public class Main {
    public static void main(String[] args) {
        // Test Eager Singleton Memory Usage
        System.out.println("Eager Singleton initialized at class loading");
        Singleton2 instance1 = Singleton2.getIns();
        Singleton2 instance2 = Singleton2.getIns();
        System.out.println("Eager Singleton: " + (instance1 == instance2 ? "Same Instance" : "Different Instances"));
    }
        
}
