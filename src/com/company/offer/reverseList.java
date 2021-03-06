package com.company.offer;

import com.company.normal.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class reverseList {
    //相当于先生成一个头节点，之后用头插法完成逆转
    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = listNode.next;
            listNode.next = temp;
            head = head.next;
        }
        return listNode.next;
    }
}
