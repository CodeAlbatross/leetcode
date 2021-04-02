package com.company.offer;

public class nthUglyNumber {
    /**
     * 剑指 Offer 49. 丑数
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 说明:
     * <p>
     * 1 是丑数。
     * n 不超过1690。
     * <p>
     * 说白了，就是把所有丑数列出来，然后从小到大排序。
     * 而大的丑数必然是小丑数的2/3/5倍，所以有了那3个数组。
     * 每次就从那数组中取出一个最小的丑数归并到目标数组中。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        //a,b,c代表前a,b,c个数被2，3，5乘过
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            //第i个丑数一定是乘2，3，5中最小的那一个
            dp[i] = Math.min(n2, Math.min(n3, n5));
            //若dp[i] == nx,则前i个数（i=a或b或c）被x（x=1或2或3）乘过
            //则，相等的a, b, c自增1，代表前a，b, c个数被2，3，5乘过
            if (dp[i] == n2)
                a++;
            if (dp[i] == n3)
                b++;
            if (dp[i] == n5)
                c++;
        }
        return dp[n - 1];
    }
}
