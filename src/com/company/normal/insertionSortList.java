package com.company.normal;

public class insertionSortList {
    /**
     * 单链表插入排序
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode insert = head.next;
        ListNode sortHead = head;//排序头
        ListNode sortRear = head;//排序尾

        while (insert != null) {
            ListNode temp = sortHead;
            if (insert.val <= temp.val) {
                sortRear.next = insert.next;
                insert.next = sortHead;
                sortHead = insert;
                insert = sortRear.next;
                continue;
            }
            if (insert.val >= sortRear.val) {
                sortRear = insert;
                insert = insert.next;
                continue;
            }
            while (insert != null && temp != sortRear && temp.next.val < insert.val) {
                temp = temp.next;
            }
            sortRear.next = insert.next;
            insert.next = temp.next;
            temp.next = insert;
            insert = sortRear.next;
        }
        return sortHead;
    }
}
