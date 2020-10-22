package com.company.offer;

import com.company.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class reorderList {
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        int mid = 0;
        ListNode midList = head;
        ListNode assistList = head;
        while (assistList != null && assistList.next != null)
        {
            ++mid;
            midList = midList.next;
            assistList = assistList.next.next;
        }
        assistList = reverseList(midList);
        ListNode temp = head;
        while (mid > 1){
            temp = temp.next;
            mid--;
        }
        temp.next = null;
        temp = head;
        ListNode temp1 = temp.next;
        while (temp1 != null && assistList != null){
            ListNode temp2 = assistList.next;
            temp.next = assistList;
            assistList.next = temp1;
            assistList = temp2;
            temp = temp1;
            temp1 = temp1.next;
        }
        if (assistList != null){
            temp.next = assistList;
        }
    }
    private ListNode reverseList(ListNode midList) {
        if (midList == null || midList.next == null)
            return midList;
        ListNode reverse = reverseList(midList.next);
        midList.next.next = midList;
        midList.next = null;
        return reverse;
    }
}
