package com.company.normal;

public class checkPossibility {
    /**
     * 665. 非递减数列
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     *
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *
     * 思路: 遍历数组, 若出现i上的元素大于j(i + 1 = j)上的元素,则修改int[i] = int[j],由于此前k<i的int[k]都小于等于int[i],
     * 所以若int[j] < int [i-1], 则需要复原之后修改int[j] = int [i]
     * 当需要修改第二次的时候,则失败
     * 总的来说是贪心算法的思想,保证每一个相邻元素都是非递减的
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int cnn = 0;
        for (int i = 0; i < nums.length-1; i++){
            int a = nums[i], b = nums[i+1];
            int temp = nums[i];
            if (a > b){
                nums[i] = nums[i+1];
                cnn++;
                if (cnn >= 2)
                    return false;
                if (i > 0){
                    if (nums[i - 1] > nums[i]){
                        nums[i] = temp;
                        nums[i + 1] = temp;
                    }
                }

            }

        }
        return true;
    }
}
