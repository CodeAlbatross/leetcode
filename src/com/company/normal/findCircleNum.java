package com.company.normal;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 */
public class findCircleNum {
    private int count = 0;

    /**
     * 原理就是求连通分量
     * 用原数组对角线元素保存被访问的点，dfs求从i点出发的每一个连通点，访问到的点标记
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        //int[] visited = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++){
            if (isConnected[i][i] == 0)
                continue;
            dfs(isConnected,i);
            count++;
        }
        return count;
    }

    private void dfs(int[][] isConnected, int x){
        if (isConnected[x][x] == 0)
            return;
        isConnected[x][x] = 0;
        for (int i = 0 ; i < isConnected.length; i++){
            if (isConnected[x][i] == 1 && x!=i){
                dfs(isConnected,i);
            }
        }
    }
    public static void main(String[] args){
        System.out.println(new findCircleNum().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
