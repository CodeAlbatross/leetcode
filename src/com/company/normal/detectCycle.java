package com.company.normal;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以不用额外空间解决此题？
 */

public class detectCycle {
    /**
     * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与 slow 指针在环中相遇。
     * <p>
     * 如下图所示，设链表中环外部分的长度为 a。slow 指针进入环后，又走了 bb 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc。
     * <p>
     * <p>
     * <p>
     * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
     * <p>
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * <p>
     * 有了 a=c+(n-1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     * <p>
     * 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast.next == null || fast.next.next == null || slow.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return slow;
    }
}
