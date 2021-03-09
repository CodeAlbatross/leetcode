package com.company.normal;

public class pivotIndex {
    /**
     * 724. 寻找数组的中心索引
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     *
     * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *
     * 思路: 左边总和 * 2 + 中心索引 = 总和
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int lSum = 0;
        for (int num : nums){
            sum += num;
        }
        for (int i = 0; i < nums.length; i++){
            if (lSum * 2 + nums[i] == sum)
                return i;
            lSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new pivotIndex().pivotIndex(new int[]{}));
    }
}
