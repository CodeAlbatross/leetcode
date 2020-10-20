package com.company.offer;



import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */

class reversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
        }
        int[] nums = new int[stack.size()];
        int i = 0;
        while (!stack.empty()){
            nums[i++] = stack.pop();
        }
        return nums;
    }
}