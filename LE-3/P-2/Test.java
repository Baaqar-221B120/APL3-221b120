public class Test implements Testable {
    public void display() {
        System.out.println("Display method in Test class");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.display();
    }
}
