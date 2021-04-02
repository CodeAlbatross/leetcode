package com.company.offer;

public class printNumbers {
    public int[] printNumbers(int n) {
        int[] nums = new int[(int) Math.pow(10, n)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        return nums;
    }
}
