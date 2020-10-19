package com.company.offer;

import java.util.LinkedList;
import java.util.Queue;

class CQueue {
    Queue<Integer> queue = new LinkedList<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        queue.offer(value);
    }

    public int deleteHead() {
        if (queue.isEmpty()){
            return -1;
        }else {
            return queue.poll();
        }


    }
}