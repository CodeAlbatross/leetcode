package com.company.normal;

import java.util.Arrays;
import java.util.Comparator;

public class fairCandySwap {
    /**
     * 888. 公平的糖果棒交换
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
     * <p>
     * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     * <p>
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     * <p>
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1,1], B = [2,2]
     * 输出：[1,2]
     * 示例 2：
     * <p>
     * 输入：A = [1,2], B = [2,3]
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：A = [2], B = [1,3]
     * 输出：[2,3]
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int ASum = 0;
        int BSum = 0;

        for (int j : A) {
            ASum += j;
        }
        for (int j : B) {
            BSum += j;
        }
        int average = (ASum + BSum) / 2;

        if (ASum > BSum) {
            int abs = (ASum - average);
            for (int k : A) {
                for (int i : B) {
                    if (k - i == -abs) {
                        return new int[]{k, i};
                    }
                }
            }
        } else {
            int abs = (BSum - average);
            for (int k : B) {
                for (int i : A) {
                    if (k - i == -abs) {
                        return new int[]{i, k};
                    }
                }
            }
        }
        return null;
    }


}
