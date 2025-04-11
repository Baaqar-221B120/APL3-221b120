class Main
{
    public static void main(String[] args){
        Offering c1 = new Coffee(); // Base Coffee
        c1 = new Rum(c1);
        c1 = new Rum(c1);
        System.out.println("Offering: "+c1.getName() +", cost: Rs."+c1.getPrice());
        Offering c2 = new Tea(); // Base Tea
        c2 = new Gin(c2);
        System.out.println("Offering: "+c2.getName() +", cost: Rs."+c2.getPrice());
        Offering c3 = new Icecream(); // Base Icecream
        c3 = new Gin(c3);
        c3 = new Gin(c3);
        System.out.println("Offering: "+c3.getName() +", cost: Rs."+c3.getPrice());
    }
}