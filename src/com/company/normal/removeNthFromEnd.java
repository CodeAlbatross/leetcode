package com.company.normal;

/**
 * 删除倒数第n个链节点
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode listNode1 = head;
        ListNode listNode2 = head;
        while (n > 0) {
            listNode2 = listNode2.next;
            --n;
        }
        if (listNode2 == null) {
            head = head.next;
            return head;
        }
        while (listNode2 != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        listNode1.next = listNode1.next.next;
        return head;
    }
}
