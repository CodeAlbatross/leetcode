package com.company;

public class father {
    private int age;
    public int id;
    int num;

    public father(int age, int id) {
        this.age = age;
        this.id = id;
    }
}
class son extends father{
    public son(int age, int id) {
        super(age, id);

    }

    public static void main(String[] a){
        son son = new son(2,3);
        System.out.println(son);

    }
}

