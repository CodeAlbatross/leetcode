package com.company.Dp;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class _64_minPathSum {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int weight = grid[0].length;
        int[][] dp = new int[height][weight];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (i != 0) {
                    dp[i][j] =grid[i][j] +  Math.min(dp[i - 1][j] , dp[i][j - 1]);
                }

            }
        }
        return dp[height-1][weight-1];
    }
}
