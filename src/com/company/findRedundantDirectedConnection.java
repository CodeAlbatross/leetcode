package com.company;

/**
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 *
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 *
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 * 示例1:
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 *   1
 *  / \
 * v   v
 * 2-->3
 * 示例 2:
 *
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 *
 */
class findRedundantDirectedConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodeCount = edges.length;
        UnionFind unionFind = new UnionFind(nodeCount+1);
        int[] parent = new int[nodeCount+1];
        for (int i = 1; i<=nodeCount; i++ ){
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodeCount; ++i){
            //访问到边 [u,v]
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if (parent[node2] != node2){
                //如果此时已经有{parent}[v] != v
                //说明 v 有两个父节点，将当前的边 [u,v]记为导致冲突的边；
                conflict = i;
            }else {
                //否则，令 {parent}[v] = u,
                // 然后在并查集中分别找到 u 和 v 的祖先（即各自的连通分支中的根节点），
                // 如果祖先相同，说明这条边导致环路出现，将当前的边 [u,v]记为导致环路出现的边，
                // 如果祖先不同，则在并查集中将 u 和 v 进行合并。
                parent[node2] = node1;
                if (unionFind.find(node1) == unionFind.find(node2)){
                    cycle = i;
                }else unionFind.merge(node1,node2);
            }
        }
        if (conflict < 0){
            //如果没有导致冲突的边，说明附加的边一定导致环路出现，
            //而且是在环路中的最后一条被访问到的边，因此附加的边即为导致环路出现的边。
            return new int[]{edges[cycle][0], edges[cycle][1]};

        }else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0){
                //如果有导致环路的边，
                // 则附加的边不可能是 [u,v]（因为 [u,v] 已经被记为导致冲突的边，不可能被记为导致环路出现的边），
                // 因此附加的边是 [{parent}[v],v]]。
                return new int[]{parent[conflictEdge[1]],conflictEdge[1]};
            }else {
                //如果没有导致环路的边，则附加的边是后被访问到的指向 v 的边，因此附加的边是 [u,v]。
                return new int[]{conflictEdge[0],conflictEdge[1]};
            }
        }

    }
}

/**
 * 并查集
 */
class UnionFind{
    int[] fa;
    int[] rank;
    //初始化（按秩合并）
    public UnionFind(int n){
        fa = new int[n+1];
        rank = new int[n+1];
        for (int i = 1; i<=n; i++ ){
            fa[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if (x == fa[x]){
            return x;
        }else {
            fa[x] = find(fa[x]);//父节点设置为根节点
            return fa[x];//返回父节点
        }
    }
    public void merge(int i, int j){
        int x = find(i);
        int y = find(j);//先找到两个根节点
        if(rank[x] <= rank[y]){
            fa[x] = y;
        }else fa[y] = x;
        if (rank[x] == rank[y] && x != y){
            rank[y]++;//如果深度相同且根节点不同，则新的根节点的深度+1
        }
    }
}
