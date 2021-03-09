package com.company.normal;

/**
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 */
public class totalNQueens {
    private int sum = 0;


    public int totalNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        dfs(0,visited,n);
        return sum;
    }
    private void dfs(int x,boolean[][] visited,int n){
        if (x == n){
            sum++;
            return;
        }
        for (int col = 0; col < n; col++){
            if (can(x,col,visited)){
                visited[x][col] = true;
                dfs(x+1,visited,n);
                visited[x][col] = false;
            }
        }



    }
    private boolean can(int x,int y, boolean[][] checkerboard){

        for (boolean[] booleans : checkerboard) {
            if (booleans[y]) {
                return false;
            }
        }

        for (int i = 0; (y+i) < checkerboard.length && (x-i) >=0; i++){
            if (checkerboard[x-i][y+i]){
                return false;
            }
        }
        for (int i = 0; (x-i) >= 0 && (y-i) >= 0; i++){
            if (checkerboard[x-i][y-i]){
                return false;
            }
        }
        return true;
    }
}
