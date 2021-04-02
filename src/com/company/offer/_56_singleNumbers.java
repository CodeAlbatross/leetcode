package com.company.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 */
public class _56_singleNumbers {
    public int[] singleNumbers(int[] nums) {
        int num = 0;
        for (int a : nums) {
            num ^= a;
        }
        int index = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            ++index;
        }
        int r1 = 0, r2 = 0;
        for (int a : nums) {
            if ((a & (1 << index)) == 0) {
                r1 ^= a;
            } else {
                r2 ^= a;
            }
        }
        return new int[]{r1, r2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _56_singleNumbers().singleNumbers(new int[]{4, 1, 4, 6})));
    }
}
