package com.company.offer;

/**
 * 斐波拉契
 */
public class fib {
    public int fib(int n) {
        int a=0, b=1, c=0;
        if (n == 1)
            return a;
        if (n == 2)
            return b;
        for (int i = 1; i < n-1; i++){
            c = (a+b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
