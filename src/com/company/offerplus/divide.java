package com.company.offerplus;

public class divide {
    public static int divide(int a, int b) {
        // 考虑被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (a == 0) {
            return 0;
        }

        int left = 1, right = Integer.MAX_VALUE;
        int result = 0;
        boolean rev = false;
        if (a > 0){
            a = -a;
            rev = true;
        }
        if (b > 0){
            b = -b;
            rev = !rev;
        }
         while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (quickAdd(b,mid,a)){
                result = mid;
                if (mid == Integer.MAX_VALUE){
                    break;
                }
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return rev ? -result : result;
    }

    // 快速乘
    public static boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result + add >= x) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add + add >= x) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(divide(5,2));
    }
}
