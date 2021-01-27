package com.company;

import java.util.HashSet;
import java.util.Set;

public class findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges){
            if (unionFind.find(edge[0]) == unionFind.find(edge[1])){
                return new int[]{edge[0],edge[1]};
            }else {
                unionFind.merge(edge[0],edge[1]);
            }
        }
        return new int[0];
    }
    private class UnionFind{
        private int[] fa;//保存父节点
        private int[] rank;//保存树的高度

        /**
         * 初始化
         * @param n 节点数目
         */
        public UnionFind(int n){
            fa = new int[n+1];
            rank = new int[n+1];
            for (int i = 1; i <= n; i++){
                fa[i] = i;//初始时并查集每个节点的父节点都是自己
                rank[i] = 1;//每个节点高度都是一
            }
        }
        /**
         * 找到父节点
         * @param x 节点
         * @return 父节点
         */
        public int find(int x){
            if (fa[x] == x){
                return x;
            }else{
                fa[x] = find(fa[x]);
                return fa[x];
            }
        }

        /**
         * 合并节点对
         * @param x
         * @param y
         */
        public void merge(int x, int y){
            int fx = find(x);
            int fy = find(y);
            if (rank[fx] >= rank[fy]){
                //如果x的根节点的高度大于y根节点的高度
                //则x的根节点变成y的根节点的父节点
                fa[fy] = fx;
            }else fa[fx] = fy;
            if(fx != fy && rank[fx] == rank[fy]){
                //如果根节点高度相同，且两节点不同，根节点高度+1
                rank[fy]++;
            }
        }
    }
}
