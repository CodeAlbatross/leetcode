package com.company.offer;

public class _42_maxSubArray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    //分治
    public int maxSubArray2(int[] nums) {
        return divideConquer(nums,0,nums.length-1);
    }

    public int divideConquer(int[] nums,int low,int high) {
        //递归出口
        if (low>=high){
            return nums[low];
        }
        //三种情况，数组在左区间
        //数组在right区间
        //数组横跨左右区间
        //前两种递归求解即可
        //第三种情况以中间位置向两周扩散，找到最大值
        int mid = low+(high-low)/2;
        int left = divideConquer(nums,low,mid-1);
        int right = divideConquer(nums,mid+1,high);
        int maxMid = nums[mid];
        int curMId = nums[mid];
        for (int i = mid-1;i>=low;i--){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        curMId = maxMid;
        for (int i = mid+1;i<=high;i++){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        //4.返回三种情况中的最大值
        return Math.max(Math.max(left,right),maxMid);
    }



    public static void main(String[] args) {
        System.out.println(new _42_maxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
