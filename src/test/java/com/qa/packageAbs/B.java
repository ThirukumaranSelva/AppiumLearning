package com.qa.packageAbs;

public class B extends A{
    int aa;
    B(String a,int aa) {
        super(a);
        this.aa=aa;
    }

    @Override
    void area() {
        System.out.println("Area");
    }

    @Override
    void people() {
        System.out.println("People");
    }
    static void classB(){
        System.out.println("ClassB");
    }

    public static void main(String[] args) {
        classB();
    }
}
