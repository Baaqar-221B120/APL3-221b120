class Mother
{
    // int x;
    static int x;
    // void show(){
    //     System.out.println("Attribute of Mother's class "+x);
    // }
    static void show(){ //  error: show() in Child cannot override show() in Mother ;  overridden method is static ; also requires static "x"
        System.out.println("Attribute of Mother's class "+x);
    }
}