package com.company.normal;

public class maxNumEdgesToRemove {
    /**
     * 1579. 保证图可完全遍历
     * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
     *
     * 类型 1：只能由 Alice 遍历。
     * 类型 2：只能由 Bob 遍历。
     * 类型 3：Alice 和 Bob 都可以遍历。
     * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
     *
     * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
     *
     * 思路:
     * 遵从优先添加「公共边」的策略。具体地，我们遍历每一条「公共边」，对于其连接的的两个节点：
     *
     * 如果这两个节点在同一个连通分量中，那么添加这条「公共边」是无意义的；
     *
     * 如果这两个节点不在同一个连通分量中，我们就可以（并且一定）添加这条「公共边」，然后合并这两个节点所在的连通分量。
     *
     * 这就提示了我们使用并查集来维护整个图的连通性，上述的策略只需要用到并查集的「查询」和「合并」这两个最基础的操作。
     *
     * 在处理完了所有的「公共边」之后，我们需要处理他们各自的独占边，而方法也与添加「公共边」类似。
     *
     * 我们将当前的并查集复制一份，一份交给 Alice，一份交给 Bob。
     *
     * 随后 Alice 不断地向并查集中添加「Alice 独占边」，Bob 不断地向并查集中添加「Bob 独占边」。
     *
     * 在处理完了所有的独占边之后，如果这两个并查集都只包含一个连通分量，那么就说明 Alice 和 Bob 都可以遍历整个无向图。
     *
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Union Alice = new Union(n);
        Union Bob = new Union(n);
        int ans = 0;
        //让每个边节点从0开始计数
        for (int[] edge : edges){
            edge[1]--;
            edge[2]--;
        }
        //添加公共边
        for (int[] edge : edges){
            if (edge[0] == 3){
                if (Alice.isConnected(edge[1],edge[2])){
                    ans++;
                }else{
                    Alice.merge(edge[1],edge[2]);
                    Bob.merge(edge[1],edge[2]);
                }
            }
        }
        for (int[] edge : edges){
            if (edge[0] == 1){
                //添加alice的独占边
                if (Alice.isConnected(edge[1],edge[2])){
                    ans++;
                }else{
                    Alice.merge(edge[1],edge[2]);
                }

            }else if (edge[0] == 2){
                //添加bob的独占边
                if (Bob.isConnected(edge[1],edge[2])){
                    ans++;
                }else{
                    Bob.merge(edge[1],edge[2]);
                }
            }
        }
        if (Alice.setCount > 1 || Bob.setCount > 1)
            return -1;
        return ans;
    }


}

/**
 * 并查集
 */
class Union{
    public int[] fa;
    public int[] rank;
    int setCount;//当前连通分量个数
    int n;
    public Union(int n){
        fa = new int[n];
        rank = new int[n];
        this.setCount = n;
        this.n = n;
        for (int i = 0; i < n; i++){
            fa[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if (fa[x] == x){
            return x;
        }else{
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    public boolean merge(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if (fy == fx){
            return false;
        }
        if (rank[fx] > rank[fy]){
            fa[fy] = fx;
        }else if(rank[fy] > rank[fx]){
            fa[fx] = fy;
        }else {
            fa[fx] = fy;
            rank[fy]++;
        }
        --setCount;
        return true;
    }
}