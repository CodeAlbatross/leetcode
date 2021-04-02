package com.company.begNineLessons;

import java.util.Scanner;

/**
 * 有 N 种物品和一个容量是 V 的背包。
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 */
public class the_multiBegProblem1 {
    /**
     * 二进制拆分
     * 我们考虑把第i种物品换成若干件物品，使得原问题中第i种物品可取的每种策略——取0...p[i]件——均能等价于取若干件代换以后的物品
     * 思路就是把第i种物品分为，1，2...2^k-1, si - 2^k + 1 (si - s^k + 1 > 0)件物品
     * 如果s[i]为13，就将这种物品分成系数分别为1,2,4,6的四件物品
     * <p>
     * 然后转换为01背包问题
     *
     * @param args
     */
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
            int num = Math.min(s[i], v / weight[i]);//第i种物品最大取到的个数
            for (int k = 1; num > 0; k <<= 1) {
                //k = 1,2,4... si - 2^k + 1
                if (k > num) k = num;
                num -= k;
                for (int j = v; j >= weight[i] * k; j--) {
                    f[j] = Math.max(f[j], f[j - weight[i] * k] + value[i] * k);
                }
            }
        }
        System.out.println(f[v]);
    }
}
