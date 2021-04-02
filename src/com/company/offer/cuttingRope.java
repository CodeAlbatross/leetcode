package com.company.offer;

import java.awt.event.MouseAdapter;

/**
 * 本题说的将绳子剪成m段，m是大于1的任意一个正整数，也就是必须剪这个绳子，至于剪成几段，每一段多长，才能使得乘积最大
 */
public class cuttingRope {
    /**
     * 数论
     * 数学证明：定义函数 f(x) 表示将给定的正整数 n 拆分成尽可能多的正数 x 的情况下的最大乘积，则可以将 n 分成 \frac{n}{x}
     * x
     * n
     * 项，此时 f(x)=x^{\frac{n}{x}}f(x)=x
     * x
     * n
     * ，通过求导可得f(x)在x=e时取最大值，f(3)>f(2)，x=3 时，可以得到最大乘积。
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 3)
            return n - 1;
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 2) {
            return (int) Math.pow(3, quotient) * 2;
        } else {
            return (int) Math.pow(3, quotient - 1) * 4;
        }
    }

    /**
     * 动态规划
     * dp[i] = max(不剪, 继续剪) = max(dp[i], 继续剪)。
     * 如果继续剪，就会剪为左右两部分，即‘继续剪’ = max(左边) * max(右边)，亦即各取左边和右边最大值之积作为剪一刀后最大值。
     * 而无论左边还是右边，同样也可以继续都选择不剪和继续剪。那左边为例：‘左边’ = max('不剪', ‘继续剪’)。
     * <p>
     * 故最终公式为：dp[i]
     * = max['i选择不剪', max(‘左边选择不剪’, ‘左边继续剪’) * max(‘右边选择不剪’, ‘右边继续剪’)]
     * = max[dp[i], max(j, dp[j]) * max(i-j, dp[i-j])]
     */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }
}
