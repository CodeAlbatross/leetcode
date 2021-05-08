package com.company.normal;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class _16_threeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);//先排序
        int max = 100000;//差值
        int len = nums.length;
        int ans = max;//答案
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                //剪枝,当遍历的数字跟前一个相同的时候直接跳过,也是确保三个数字都是不同的
                continue;
            }
            int j = i+1;//j = i + 1确保每次三个数字都是不同的
            int k = len-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < max){
                    ans = sum;
                }
                max = Math.min(max,Math.abs(sum - target));
                if (sum == target){
                    //如果三个数 的和跟target相同直接返回
                    return target;
                }else if (sum > target){
                    //因为是排序的,所以当和大于目标值,尾部数字下标--
                    --k;
                }else {
                    //因为是排序的,所以当和小于目标值,头部数字下标++
                    ++j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
