package com.company.offer;

import java.util.Arrays;
import java.util.Comparator;

public class _51_reversePairs {
    /**
     * 剑指 Offer 51. 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     * 示例 1:
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {

        int len = nums.length;
        if (len < 2)
            return 0;
        int[] temp = new int[len];
        return reversePairs(nums,0,len-1,temp);
    }
    private int reversePairs(int[] nums,int left, int right,int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums,left,mid,temp);
        int rightCount = reversePairs(nums,mid+1,right,temp);

        //如果左半边都小于右半边说明不用合并
        if (nums[mid] <= nums[mid + 1]){
            return leftCount + rightCount;
        }

        return leftCount + rightCount + mergeAndCount(nums,left,mid,right,temp);
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        if (right + 1 - left >= 0) System.arraycopy(nums, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid+1;
        int count = 0;
        for (int k = left; k <= right ; k++) {
            if (i == mid + 1){
                nums[k] = temp[j];
                ++j;
            }else if (j == right + 1){
                nums[k] = temp[i];
                ++i;
            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                ++i;
            }else {
                nums[k] = temp[j];
                count += (mid - i + 1);
                ++j;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _51_reversePairs().reversePairs(new int[]{1,3,2,3,1}));
    }
}
