package com.company.normal;

import java.util.HashMap;
import java.util.Map;

public class fourSumCount {
    /**
     * 454. 四数相加 II
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     * <p>
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     * <p>
     * 例如:
     * <p>
     * 输入:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     * <p>
     * 输出:
     * 2
     * <p>
     * 解释:
     * 两个元组如下:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        //先把ab分为一组，记录所有相应ab的和出现的次数
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                countAB.put(a + b, countAB.getOrDefault(a + b, 0) + 1);
            }
        }
        //之后遍历cd，若出现ab和的负数，就说明存在和为0；
        for (int c : C) {
            for (int d : D) {
                if (countAB.containsKey(-c - d)) {
                    count += countAB.get(-c - d);
                }
            }
        }

        return count;
    }
}
