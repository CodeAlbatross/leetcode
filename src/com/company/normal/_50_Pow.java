package com.company.normal;

public class _50_Pow {
    /**
     * 50. Pow(x, n)
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     * <p>
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     * <p>
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n >= 0) {
            return myPowPositive(x, n);
        } else {
            return 1 / myPowPositive(x, -n);
        }
    }

    private double myPowPositive(double x, long n) {
        double result = 1.0;
        if (n < 0) {
            n = -n;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _50_Pow().myPow(2.0, -2147483648));
    }
}
