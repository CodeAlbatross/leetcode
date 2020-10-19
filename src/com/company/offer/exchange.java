package com.company.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
public class exchange {
    public int[] exchange(int[] nums) {
        int evenIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & 1) == 0){
                evenIndex = i;
                break;
            }
        }
        for (int i = evenIndex+1; i < nums.length; i++){
            if ((nums[i] & 1) == 1){
                int temp = nums[i];
                nums[i] = nums[evenIndex];
                nums[evenIndex] = temp;
                ++evenIndex;
            }
        }
        return nums;
    }
}
