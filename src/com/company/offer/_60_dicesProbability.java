package com.company.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * <p>
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class _60_dicesProbability {
    /**
     * 当有n个骰子的时候，只与n-1个骰子各概率有关
     * 第n个骰子的x点数，等于第n-1个骰子点数x-i（i<x）概率 / 6 之和
     * <p>
     * 由于新增骰子的点数只可能为 11 至 66 ，
     * 因此概率 f(n - 1, x) 仅与 f(n, x + 1) , f(n, x + 2), ... , f(n, x + 6) 相关。
     * 因而，遍历 f(n - 1) 中各点数和的概率，
     * 并将其相加至 f(n)中所有相关项，即可完成 f(n - 1) 至 f(n)的递推
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
