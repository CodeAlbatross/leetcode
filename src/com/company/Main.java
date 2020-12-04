package com.company;

import org.w3c.dom.ls.LSOutput;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Main{
    @Target(ElementType.METHOD)
    public @interface TargetTest{
        String hello();
    }

    @TargetTest(hello = "123")
    public static void doss(){
        System.out.println("do something");

    }
    
    public static void main(String[] args) {
        doss();
    }

}
