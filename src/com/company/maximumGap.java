package com.company;

import java.util.Arrays;

public class maximumGap {
    /**
     * 164. 最大间距
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     *
     * 如果数组元素个数小于 2，则返回 0。
     *
     * 示例 1:
     *
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     * 示例 2:
     *
     * 输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     * 说明:
     *
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        //设长度为 N 的数组中最大值为 {max,min}则不难发现相邻数字的最大间距不会小于 ⌈(max−min)/(N−1)⌉。
        //我们可以选取整数 d=⌊(max−min)/(N−1)⌋ < ⌈(max−min)/(N−1)⌉。
        // 随后，我们将整个区间划分为若干个大小为 dd 的桶，并找出每个整数所在的桶。
        // 根据前面的结论，能够知道，元素之间的最大间距一定不会出现在某个桶的内部，而一定会出现在不同桶当中。


        if (nums.length <= 1)
            return 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        int d = Math.max (1,(max - min)/(nums.length-1));
        int bucketSize = (max - min) / d + 1;
        //在找出每个元素所在的桶之后，我们可以维护每个桶内元素的最大值与最小值
        int[][] bucket = new int[bucketSize][2];//桶里只需要储存最大值和最小值
        for (int i = 0; i < bucketSize; ++i) {
            Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }
        for (int i = 0; i < nums.length; i++){
            int idx = (nums[i] - min) / d;
            if (bucket[idx][0] == -1) {
                //桶是空的
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                //桶不空
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }

        }
        //从前到后不断比较相邻的桶，用后一个桶的最小值与前一个桶的最大值之差作为两个桶的间距
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;


    }
}
