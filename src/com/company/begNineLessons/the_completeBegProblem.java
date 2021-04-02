package com.company.begNineLessons;

import java.util.Scanner;

/**
 * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 *
 * 第 i 种物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */
public class the_completeBegProblem {
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



        // 一维数组
        // f[j] = max(f[j], f[j - w[i]] + v[i]);
        int[] f = new int[v+1];
        for (int i = 1; i <= n; i++) {
            for (int j = weight[i]; j <= v ; j++) {
                //因为每一件物品都可以拿n次，所以不用担心计算f[j]的时候受j前边的影响
                f[j] = Math.max(f[j],f[j - weight[i]] + value[i]);
            }
        }


        System.out.println(f[v]);
        return f[v];
    }
}
