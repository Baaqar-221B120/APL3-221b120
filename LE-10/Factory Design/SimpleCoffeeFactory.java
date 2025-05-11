public class SimpleCoffeeFactory {
    public static Coffee makeCoffee(String type) {
        if (type.equalsIgnoreCase("espresso")) {
            return new Espresso();
        } else if (type.equalsIgnoreCase("latte")) {
            return new Latte();
        } else if (type.equalsIgnoreCase("cappuccino")) {
            return new Cappuccino();
        } else {
            return new Latte(); // Default
        }
    }
}