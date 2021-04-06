package com.company.Dp;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 *
 */
public class _787_BellmanFord {
    /**
     * BellmanFord算法,求单源最短路径问题,边可以为负值
     * 传统的算法是对边进行|V|-1次操作,每次操作对所有的边进行一次松弛
     * 这里因为要求k个中转站,相当于走了k+1次,只需要进行k+1次操作
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //用一个二维数组dp[i][k],表示经过k个中转站之后到达i站的最小费用
        int[][] dp = new int[n][K+1];
        int MAX = 0x3f3f3f;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], MAX);
        }
        // 自己到自己,最短距离为0
        for(int i = 0; i <= K; i++){
            dp[src][i] = 0;
        }

        //第一次松弛,只遍历由原点可直达的
        for (int[] flight : flights){
            if (flight[0] == src){
                dp[flight[1]][0] = flight[2];//可直达
            }
        }
        //第二次到k+1次松弛
        for (int i = 1; i <= K; i++) {
            for (int[] flight :
                    flights) {
                //dp[flight[1]][i] = Math.min(dp[flight[1]][i],dp[flight[0]][i-1] + flight[2]);直接这样也是可以的,不用判断前一步是否取得最短单源路径
                //如果dp[flight[0]][i-1] == MAX,说明上一次松弛没轮到他,不管
                if (dp[flight[0]][i-1] != MAX){
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i],dp[flight[0]][i-1] + flight[2]);
                }
            }
        }
        return dp[dst][K] == MAX ? -1 : dp[dst][K];
    }
}
