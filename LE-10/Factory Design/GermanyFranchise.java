public class GermanyFranchise extends Franchise {
    @Override
    public void orderCoffee(String type) {
        Coffee coffee = SimpleCoffeeFactory.makeCoffee(type);
        System.out.println("Franchise: " + this.getClass().getSimpleName());
        coffee.brew();
        System.out.println("Served in a glass cup.");
        System.out.println();
    }
}