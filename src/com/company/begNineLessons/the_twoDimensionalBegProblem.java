package com.company.begNineLessons;

import java.util.Scanner;

/**
 * 8. 二维费用的背包问题
 *
 * 有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M。
 *
 * 每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
 * 输出最大价值。
 */
public class the_twoDimensionalBegProblem {
    public static void main(String[] args) {
        //处理输入数据
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int m = in.nextInt();
        int[] weight1 = new int[n + 1];
        int[] weight2 = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight1[i] = in.nextInt();
            weight2[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        int[][] f = new int[v+1][m+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = v; j >= weight1[i] ; j--) {
                for (int k = m; k >= weight2[i] ; k--) {
                    f[j][k] = Math.max(
                            f[j][k],
                            f[j-weight1[i]][k-weight2[i]] + value[i]
                    );
                }
            }
        }

        System.out.println(f[v][m]);
    }
}
