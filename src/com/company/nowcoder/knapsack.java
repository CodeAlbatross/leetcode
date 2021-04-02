package com.company.nowcoder;

public class knapsack {
    /**
     * n个物品，限重m, 每个物品w_i
     *  , 从这几个物品中任选几个问是否能恰好装满。
     * @param m
     * @param n
     * @param weights
     */
    public static void knapsack(int m, int n, int[] weights) {
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        for (int i=0; i < n; i++) {
            for (int v=m; v >= weights[i]; v--) {
                dp[v] = dp[v] || dp[v-weights[i]];
            }
        }
        System.out.println(dp[m]);
    }

    public static void main(String[] args) {
        knapsack(10,3,new int[]{7,3,9});
    }
}
