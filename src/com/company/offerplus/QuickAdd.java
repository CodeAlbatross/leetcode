package com.company.offerplus;

/**
 * 快速乘
 */
public class QuickAdd {
    public static long quickAdd(long a, long b){
        System.out.println(a * b);
        long ans = 0;
        while (b != 0){
            if ((b & 1) != 0){
                ans += a;
            }
            a += a;
            b >>= 1;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        quickAdd(3,3);
    }
}
