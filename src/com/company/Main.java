package com.company;



public class Main{
    public static void main(String[] args) {
        test s = new test();
        System.out.println(s.getA());
    }

}
class test{
    int a;

    public int getA() {
        return a;
    }
}