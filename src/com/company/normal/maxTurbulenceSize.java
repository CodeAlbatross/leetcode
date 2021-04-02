package com.company.normal;

public class maxTurbulenceSize {
    /**
     * 978. 最长湍流子数组
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     * <p>
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     * <p>
     * 返回 A 的最大湍流子数组的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[9,4,2,10,7,8,8,1,9]
     * 输出：5
     * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
     *
     * @param A
     * @return
     */
    public int maxTurbulenceSize(int[] A) {
        int length = A.length;
        if (length == 1)
            return length;
        int index = 0;
        while (index < length - 2 && A[index] == A[index + 1]) {
            index++;
        }
        boolean isUp = A[index] < A[index + 1];
        int count = 2;
        int max = 1;
        if (A[index] != A[index + 1])
            max = 2;
        for (int i = index + 1; i < length - 1; i++) {
            if (isUp) {
                if (A[i] > A[i + 1]) {
                    ++count;
                    isUp = false;
                } else {
                    count = 2;
                    while (i < length - 2 && A[i] == A[i + 1]) {
                        i++;
                    }
                    isUp = A[i] < A[i + 1];
                }
            } else {
                if (A[i] < A[i + 1]) {
                    ++count;
                    isUp = true;
                } else {
                    count = 2;

                    while (i < length - 2 && A[i] == A[i + 1]) {
                        i++;
                    }
                    isUp = A[i] < A[i + 1];
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new maxTurbulenceSize().maxTurbulenceSize(new int[]{9, 10}));
    }
}
