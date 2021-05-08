package com.company.Dp;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

 * 示例 1：
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 */
public class _221_maximalSquare {
    /**
     * 用max记录正方形的最大边长
     * 当一个方块为正方形的右下角时,他的左边右边和左上角一定也为一个正方形的右下角
     * 不然这个正方形就只能是他自己
     * 所以dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int weight = matrix[0].length;
        int[][] dp = new int[height+1][weight+1];
        int max = 0;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= weight; j++) {
                if (matrix[i-1][j-1] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
