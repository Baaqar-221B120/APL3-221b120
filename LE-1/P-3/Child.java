class Child extends Mother
{
    // int x;
    static int x;

    // void show(){
    //     System.out.println("Attribute of Child's class "+x);
    // }
    static void show(){ //  error: show() in Child cannot override show() in Mother ; overriding method is static ; also requires static "x"
        System.out.println("Attribute of Child's class "+x);
    }
}