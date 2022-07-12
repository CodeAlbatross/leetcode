package com.company.AdvancedSoftwareEngineering.Polymorphism;

public class Demo {
    public static void main(String[] args) {
        A a = new B();
        a.print();
        a = new C();
        a.print();
    }
}
