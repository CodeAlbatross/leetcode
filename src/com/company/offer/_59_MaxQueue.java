package com.company.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
class MaxQueue {
    Deque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty())
            return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}
