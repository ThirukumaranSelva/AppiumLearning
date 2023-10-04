package com.qa.packageAbs;

abstract class A {
    abstract void area();
    abstract void people();
    A(String a){
        System.out.println(a);
    }
    static void classA(){
        System.out.println("ClassA");
    }

    public static void main(String[] args) {
        classA();
    }
}
