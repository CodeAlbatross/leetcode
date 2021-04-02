package com.company.offer;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class sortedSquares {
    public int[] sortedSquares(int[] A) {
        int i = 0;
        int length1 = 0;
        while (i < A.length) {
            if (A[i] < 0)
                length1++;
            A[i] *= A[i];
            ++i;
        }

        int[] B = new int[A.length];
        int x = length1 - 1, y = length1;
        i = 0;
        while (x >= 0 && y < A.length) {
            if (A[x] < A[y]) {
                B[i] = A[x];
                --x;
            } else {
                B[i] = A[y];
                ++y;
            }
            ++i;
        }
        while (x >= 0) {
            B[i++] = A[x--];
        }
        while (y < A.length) {
            B[i++] = A[y++];
        }

        return B;
    }
}
