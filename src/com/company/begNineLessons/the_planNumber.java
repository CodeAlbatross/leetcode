package com.company.begNineLessons;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 背包问题求方案数
 *
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 *
 * 输出 最优选法的方案数。注意答案可能很大，请输出答案模 109+7 的结果。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 */
public class the_planNumber {
    public static void main(String[] args) {
        //处理输入数据
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        int[] f = new int[v+1];
        int[] g = new int[v+1];//保存当前最佳方案数
        Arrays.fill(g,1);

        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= weight[i]; j--) {
                int left = f[j];
                int right = f[j-weight[i]] + value[i];
                f[j] = Math.max(left,right);
                if (left > right) g[j] = g[j];//当前物品不加入方案，方案数不变
                else if (left < right) g[j] = g[j-weight[i]];//当前物品加入方案，方案数更新
                else g[j] = g[j] + g[j-weight[i]];//加入不加入方案都是最优的，所以方案数相加
                g[j] %= 1000000007;

            }
        }
        System.out.println(g[v]);
    }
}
