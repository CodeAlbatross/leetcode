package com.company.begNineLessons;

import java.util.Scanner;

/**
 * 背包问题求具体方案
 *    题目
 *    提交记录
 *    讨论
 *    题解
 *    视频讲解
 *
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 *
 * 输出 字典序最小的方案。这里的字典序是指：所选物品的编号所构成的序列。物品的编号范围是 1…N。
 */
public class the_realPlan {
    public static void main(String[] args) {
        //处理输入数据
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        //物品逆序排列
        //因为最后是根据最后方案逆推的，所以逆序排列物品，这样逆推出来就是正序了
        //也就是最小字典序
        for (int i = n; i >=1; i--) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        int[][] f = new int[n+1][v+1];
        // 记录下每个状态的最优值是由状态转移方程的哪一项推出来的，
        // 换句话说，记录下它是由哪一个策略推出来的。
        // 便可根据这条策略找到上一个状态，从上一个状态接着向前推即可。
        boolean[][] g = new boolean[n+1][v+1];//g[i][j]来表示当前物品是否取
        g[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=v ; j++) {
                if (j >= weight[i]){
                    int left = f[i-1][j];
                    int right = f[i-1][j-weight[i]] + value[i];
                    f[i][j] = Math.max(left,right);
                    g[i][j] = left <= right;
                }else {
                    f[i][j] = f[i-1][j];
                }

            }
        }
        int i = n, j=v;
        while (i > 0){
            if (g[i][j]){
                //当前方案这个物品取了，输出他
                //因为一开始物品是逆序输入的，所以物品序号要处理一下
                System.out.print( n-i+1 +" ");
                //然后通过这个物品逆序找到他的上一个物品
                j-=weight[i];
            }
            i-=1;
        }
    }
}
