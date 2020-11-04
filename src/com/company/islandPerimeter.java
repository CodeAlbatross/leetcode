package com.company;

public class islandPerimeter {
    private final int[] xs = new int[]{1,0,-1,0};
    private final int[] ys = new int[]{0,1,0,-1};
    private int sum = 0;
    public int islandPerimeter(int[][] grid) {
        dfs(0,0,new boolean[grid.length][grid[0].length],grid);
        return sum;
    }
    private void dfs(int x, int y, boolean[][] visited, int[][] grid){
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        if (grid[x][y] == 1){
            int n = 4;
            for (int i = 0; i < 4; i++){
                if (x+xs[i] >= 0 && y+ys[i] >= 0 && x+xs[i] < grid.length && y+ys[i] < grid[0].length){
                    if (grid[x+xs[i]][y+ys[i]]==1){
                        --n;
                    }
                }
            }
            sum += n;
        }
        for (int i = 0; i < 4; i++){
            dfs(x+xs[i],y+ys[i],visited,grid);
        }
    }
}
