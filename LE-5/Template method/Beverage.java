abstract class Beverage
{
    private void pour(int qty)
    {
        System.out.println("Pour "+qty+" ml of the liquid.");
    }
    protected abstract void add();
    protected void stir() {}; // hook funtion
    private void serve()
    {
        System.out.println("Beverage served.");
    }
    public void prepare(int qty){
        pour(qty); add(); stir(); serve();
    }
}