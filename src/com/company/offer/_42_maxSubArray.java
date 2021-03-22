package com.company.offer;

public class _42_maxSubArray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            }else {
                dp[i] = Math.max(dp[i],dp[i-1]+nums[i]);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _42_maxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
