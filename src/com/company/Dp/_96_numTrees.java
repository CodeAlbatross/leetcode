package com.company.Dp;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class _96_numTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //对于第i个节点当头节点时，他构成的二叉搜索树个数就是他左孩子作为头节点构成个数*右孩子节点构成的个数
        //dp[i]=∑dp[j]∗dp[i−j−1],0<=j<=i−1
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
