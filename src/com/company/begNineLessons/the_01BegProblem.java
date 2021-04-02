package com.company.begNineLessons;

import java.util.Scanner;

public class the_01BegProblem {
    /**
     * 有N 件物品和一个容量为V 的背包。第i 件物品的费用是w [ i ]，价值是v [ i ]，
     * 求将哪些物品装入背包可使价值总和最大。
     * @param n n件物品
     * @param v 容量为v的背包
     * @param weight 费用数组
     * @param value 价值数组
     * @return 最大价值
     */
    public int func1(int n, int v,int[] weight, int[] value){
        //处理输入数据
        Scanner in  = new Scanner(System.in);
        n = in.nextInt();
        v = in.nextInt();
        weight = new int[n+1];
        value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        //1. 最原始，二维数组动态规划遍历
        //  f[i][j]=max(f[i−1][j],f[i−1][j−w[i]]+v[i])

        //2. 优化成一维数组
        // 现在的f[j−w[i]]就相当于原来的f[i−1][j−w[i]]
        // f[j] = max(f[j], f[j - w[i]] + v[i]);
        int[] f = new int[v+1];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= weight[i]; j--) {
                //逆序是为了不让前面的f[j]影响后面的f[j]，保证每件物品只拿一次
                f[j] = Math.max(f[j],f[j - weight[i]] + value[i]);
            }
        }
        //3.一个常数的优化
        //int bound = max(V - sum{w[i + 1]...w[n]}, w[i]);
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + weight[i];
        }
        f = new int[v+1];
        for (int i = 1; i <= n; i++) {
            int bound = Math.max(weight[i], v - (sum[n] - sum[i]));
            for (int j = v; j >= bound; j--) {
                f[j] = Math.max(f[j],f[j - weight[i]] + value[i]);
            }
        }

        System.out.println(f[v]);
        return f[v];
    }
}
