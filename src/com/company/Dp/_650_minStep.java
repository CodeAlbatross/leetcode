package com.company.Dp;

import java.util.Arrays;

/**
 * 650. 只有两个键的键盘
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 */
public  class _650_minStep {
    public static int minSteps(int n) {
        //动态规划
        //dp[i]保存i个a的最少步骤
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[1] = 0;//一个字母不需要操作
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                //如果j是i的余数,则i可以通过j复制i/j次来实现
                if (i % j == 0){
                    dp[i] = Math.min(dp[j] + (i/j),dp[i]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(3));
    }
}
