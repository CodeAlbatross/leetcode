package com.company.offer;

public class _57_twoSum {
    /**
     * 剑指 Offer 57. 和为s的两个数字
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * <p>
     * 思路，对撞双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int s = 0;
        while (l < r) {
            s = nums[l] + nums[r];
            if (s > target) {
                --r;
            } else if (s < target) {
                ++l;
            } else return new int[]{nums[l], nums[r]};
        }
        return nums;
    }
}
