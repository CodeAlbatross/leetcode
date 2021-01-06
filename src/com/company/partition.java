package com.company;

public class partition {
    /**
     * 86. 分隔链表
     * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     *
     *
     * 示例：
     *
     * 输入：head = 1->4->3->2->5->2, x = 3
     * 输出：1->2->2->4->3->5
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode little = new ListNode(65535);
        ListNode bigger = new ListNode(65535);
        ListNode temp1 = little;
        ListNode temp2 = bigger;
        while (head != null){
            if (head.val < x){
                little.next = new ListNode(head.val);
                little = little.next;
            }else {
                bigger.next = new ListNode(head.val);
                bigger = bigger.next;
            }
            head = head.next;
        }
        little.next = temp2.next;
        return temp1.next;
    }
}
