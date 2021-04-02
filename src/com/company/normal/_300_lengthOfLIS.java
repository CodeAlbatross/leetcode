package com.company.normal;

import java.util.Arrays;

public class _300_lengthOfLIS {
    /**
     * 300. 最长递增子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //动态规划
        //dp[i] = Math.max(dp[j]+1,dp[i]);
        //dp[i]保存自己再最长递增子序列中的位置
        int length = nums.length;
        if (length == 0)
            return 0;
        int[] dp = new int[length];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果i > j则最长长度增一个
                // 否则重置最长递增子序列
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new _300_lengthOfLIS().lengthOfLIS(new int[]{186,186, 150, 200 ,160 ,130, 197, 200});
    }
}
