package com.company;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 */

public class canPartition {
    static boolean aBoolean = false;
    public boolean canPartition(int[] nums) {
        int maxNum = 0;
        int sum = 0;
        for (int num : nums){
            if (maxNum < num){
                maxNum = num;
            }
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        if (maxNum > sum / 2)
            return false;
        int target = sum / 2;

        for (int i = 0; i < nums.length; i++){
            int tempSum = 0;
            for (int j = i; j < nums.length; j++){
                if (tempSum + nums[j] == target){
                    return true;
                }else if (tempSum + nums[j] > target){

                }else {
                    tempSum += nums[j];
                }
            }
        }

        return false;
    }

}
