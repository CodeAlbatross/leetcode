package com.company.normal;

public class fib {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int ret1 = 0;
        int ret2 = 1;
        for (int i = 1; i < n; i++) {
            int temp = ret1;
            ret1 = ret2;
            ret2 += temp;
        }
        return ret2;
    }
}
