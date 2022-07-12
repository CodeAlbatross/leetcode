package com.company.AdvancedSoftwareEngineering.Closure;

public class demo {
    public static void main(String[] args) {
        demo demo = new demo();
        makeFunction mk = demo.new makeFunction();
        mk.alert();

    }
    String name  = "haha111";

    public interface displayName{
        void alert();
    }
    class makeFunction implements displayName{

        @Override
        public void alert() {
            System.out.println(name);
        }
    }
}
