package com.company.normal;

import java.util.Arrays;
import java.util.Comparator;

public class moveZeroes {
    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                zeroIndex = i;
                while (zeroIndex < nums.length && nums[zeroIndex] == 0){
                    ++zeroIndex;
                }
                if (zeroIndex == nums.length)
                    break;
                swap(nums,i,zeroIndex);

            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
