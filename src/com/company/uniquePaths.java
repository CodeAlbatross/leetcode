package com.company;

public class uniquePaths {
    private int count = 0;
    public int uniquePaths(int m, int n) {
        int[][] visited = new int[m][n];
        dfs(0,0,m,n,visited);
        return count;
    }

    /**
     * 暴力dfs
     * @param x
     * @param y
     * @param m
     * @param n
     * @param visited
     */
    private void dfs(int x, int y, int m, int n, int[][]visited){
        if (x >= m || y >=n || visited[x][y] == 1){
            return;
        }
        if (x == m-1 && y == n-1){
            ++count;
            return;
        }
        visited[x][y] = 1;
        dfs(x+1,y,m,n,visited);
        dfs(x,y+1,m,n,visited);
        visited[x][y] = 0;

    }

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsByDp(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] dp = new int[m][n];//用一个二维数组
        int[] dp1 = new int[n];//用一个一维滚动数组
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j==0){
                    dp[i][j] = 1;
                    dp1[j] = 1;
                } else{
                    dp1[j] = dp1[j-1]+dp1[j];
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }

            }
        }
        return dp1[n-1];
    }
    public static void main(String... args){
        System.out.println(new uniquePaths().uniquePathsByDp(7,3));
    }
}
