package com.company.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class _13_movingCount {
    private int count = 0;
    private final int[] xs = {0, 0, 1, -1};
    private final int[] ys = {1, -1, 0, 0};

    public int movingCount(int m, int n, int k) {
        dfs(m, n, k, 0, 0, new int[m][n]);
        return count;
    }

    private void dfs(int m, int n, int k, int x, int y, int[][] visited) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || ok(k, x, y) || visited[x][y] != 0) {
            return;
        }
        count++;
        visited[x][y] = 1;
        for (int i = 0; i < xs.length; i++) {
            dfs(m, n, k, x + xs[i], y + ys[i], visited);
        }
        // visited[x][y] = 0;
        // 此处不能回复现场，
        // 因为如果恢复了，别的路径就可能再次访问这个块造成重复
    }

    private boolean ok(int k, int i, int j) {
        return (i / 10 + i % 10 + j / 10 + j % 10) > k;
    }
}
