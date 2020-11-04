package com.company;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 */
public class smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] small = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            for (int num : nums) {
                if (num < nums[i]) {
                    ++small[i];
                }
            }
        }
        return small;
    }
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];//记录num
            data[i][1] = i;//记录num原下标
        }
        //比较二维数组的一维
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });

        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }

}
