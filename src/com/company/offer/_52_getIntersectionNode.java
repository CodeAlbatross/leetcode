package com.company.offer;

import com.company.normal.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class _52_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        int a = 0, b = 0;
        while (pointA != null) {
            ++a;
            pointA = pointA.next;
        }
        while (pointB != null) {
            ++b;
            pointB = pointB.next;
        }
        if (a > b) {
            a -= b;
            while (a != 0) {
                headA = headA.next;
                --a;
            }
        } else if (b > a) {
            b -= a;
            while (b != 0) {
                headB = headB.next;
                --b;
            }
        } else {
            if (headA == headB)
                return headA;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (h1 != h2) {
            h1 = h1 == null ? headA : h1.next;
            h2 = h2 == null ? headB : h2.next;
        }
        return h1;
    }
}
