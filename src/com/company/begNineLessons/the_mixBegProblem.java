package com.company.begNineLessons;

import java.util.Scanner;

/**
 * 7. 混合背包问题
 *
 * 有 N 种物品和一个容量是 V 的背包。
 *
 * 物品一共有三类：
 *
 * 第一类物品只能用1次（01背包）；
 * 第二类物品可以用无限次（完全背包）；
 * 第三类物品最多只能用 si 次（多重背包）；
 * 每种体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 */
public class the_mixBegProblem {
    public static void main(String[] args) {
        //处理输入数据
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
            s[i] = in.nextInt();
        }
        int[] f = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            if (s[i] == 0){
                for (int j = weight[i]; j <= v ; j++) {
                    f[j] = Math.max(f[j], f[j-weight[i]] + value[i]);
                }
            }else if (s[i] == -1){
                for (int j = v; j >= weight[i] ; j--) {
                    f[j] = Math.max(f[j], f[j-weight[i]] + value[i]);
                }
            }else {
                int num = Math.min(s[i],v/weight[i]);
                for (int k = 1; num > 0 ; k <<= 1) {
                    if (num < k) k = num;
                    num-=k;
                    for (int j = v; j >= weight[i]*k; j--) {
                        f[j] = Math.max(f[j], f[j-weight[i]*k] + value[i]*k);
                    }
                }
            }
        }
        System.out.println(f[v]);
    }
}
