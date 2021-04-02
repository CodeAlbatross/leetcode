package com.company.offer;

import com.company.normal.ListNode;

public class deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
        }
        ListNode listNode = head;
        while (listNode.next != null) {
            if (listNode.next.val == val) {
                listNode.next = listNode.next.next;
            }
            listNode = listNode.next;
        }
        return head;
    }
}
