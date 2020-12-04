package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class nextPermutation {
    /**
     * 31. 下一个排列
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //倒序查找，若相邻的两个数出现升序，则存在下一个数
        //从这两个数比较大的那一个开始，正向查找最接近他的大数
        //交换这两个数，然后对之后的数排序（因为都是降序，所以只需要头尾两两交换）
        int i;
        for (i = nums.length-1; i>0; --i){
            if (nums[i-1] < nums[i]){
                break;
            }
        }

        for (int k = i; k <= nums.length && i >0; k++){
            if (k == 0)
                break;
            if (k == nums.length) {
                swap(nums, k - 1, i - 1);
                break;
            }

            if (nums[k] < nums[i-1]) {
                swap(nums, k, i - 1);
                break;
            }
        }
        for (int k = nums.length-1; k>i ; k--,++i){
            swap(nums,i,k);

        }
        System.out.println(Arrays.toString(nums));

    }
    private void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

}
