public class Main {
    public static void main(String[] args) {
        Franchise france = new FranceFranchise();
        Franchise italy = new ItalyFranchise();
        Franchise germany = new GermanyFranchise();

        france.orderCoffee("espresso");
        italy.orderCoffee("latte");
        germany.orderCoffee("cappuccino");
    }
}