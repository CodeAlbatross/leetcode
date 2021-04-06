package com.company.Dp;

public class _474_findMaxForm {
    /**
     * 474. 一和零
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     * 示例 2：
     *
     * 输入：strs = ["10", "0", "1"], m = 1, n = 1
     * 输出：2
     * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //二维背包问题，0和1相当于两个维度的限制,每个物品价值都为1
        int[][] dp = new int[m+1][n+1];
        int len = strs.length;
        int[] zeros = new int[len];
        int[] ones = new int[len];
        for (int i = 0; i < len; i++) {
            ones[i] = countOne(strs[i]);
            zeros[i] = strs[i].length() - ones[i];
        }
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= zeros[i]; j--) {
                for (int k = n; k >= ones[i] ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros[i]][k - ones[i]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    private int countOne(String s){
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                ret++;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(new _474_findMaxForm().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,4));
    }
}
