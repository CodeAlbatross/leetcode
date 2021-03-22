package com.company.offer;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class copyRandomList {
    /**
     * 原地复制，1->2->3->null 变成 1->1->2->2->3->3->null
     * 然后再拆分
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {
        if(head == null)
            return null;
        RandomNode cur = head;
        //复制
        while(cur != null){
            RandomNode temp = cur.next;
            cur.next = new RandomNode(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;
        //赋random
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }else{
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        //拆分
        RandomNode curO = head;
        cur = head.next;
        RandomNode curTemp = cur;
        while(curTemp != null && curTemp.next != null){
            RandomNode temp = curTemp.next.next;
            RandomNode temp2 = curO.next.next;
            curO.next = temp2;
            curO = temp2;
            curTemp.next = temp;
            curTemp = temp;
        }
        curO.next = null;
        return cur;

    }
}
