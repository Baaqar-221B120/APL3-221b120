class Main
{
    public static void main(String[] args){
        Beverage b1 = new Whiskey();
        System.out.println("Preparing Whiskey");
        b1.prepare(20);
        Beverage b2 = new Beer();
        System.out.println("Preparing Beer");
        b2.prepare(100);
    }
}