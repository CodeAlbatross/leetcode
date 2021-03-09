package com.company.normal;

import java.util.Arrays;

public class rotate1D {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums,0,length-1-k);
        reverse(nums,length-k,length-1);
        reverse(nums,0,length-1);
    }
    private void reverse(int[] nums,int begin, int end){
        while (end > begin){
            int num = nums[begin];
            nums[begin] = nums[end];
            nums[end] = num;
            end--;
            begin++;
        }
    }
}
