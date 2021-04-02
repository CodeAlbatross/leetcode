package com.company.normal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _503_nextGreaterElements {
    /**
     * 503. 下一个更大元素 II
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * @param nums
     * @return 单调栈，栈中保存的是数组的下标
     * 一共两次遍历，所有连续单调下降的数列的下一个更大的数都是一样的
     * 依次把连续单调下降的数列（的下标）入栈
     * 直到找到增大的数，将所有出栈的数列响应的下一个更大的数改为这个数
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;//循环遍历

            if (stack.isEmpty()) {
                //栈为空直接入栈
                stack.push(index);
            } else if (nums[index] <= nums[stack.peek()]) {
                //下降，下降的下标入栈
                stack.push(index);
            } else {
                //遇到了更大的数，所有小于这个数的数都出栈，并且设置下一个更大的数res[stack.poll()] = nums[index];
                while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                    res[stack.poll()] = nums[index];
                }
                //将这个更大的数入栈，以便找到这个数的更大的下一个数字
                stack.push(index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _503_nextGreaterElements().nextGreaterElements(new int[]{8, 6, 5, 4, 3, 7, 6})));
    }
}
