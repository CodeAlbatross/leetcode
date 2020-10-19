package com.company;


public class hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do{
            if (fast == null || fast.next == null || fast.next.next == null || slow.next == null)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow);
        return false;
    }
}
