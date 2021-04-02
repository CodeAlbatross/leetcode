package com.company.normal;

import java.util.LinkedList;
import java.util.Queue;


public class connect {
    /**
     * 用队列
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        int front = -1, rear = -1;
        int last = 0;
        queue.offer(root);
        ++rear;
        Node p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            ++front;

            if (p.left != null) {
                queue.offer(p.left);
                ++rear;
            }
            if (p.right != null) {
                queue.offer(p.right);
                ++rear;
            }

            if (front == last) {
                last = rear;
            } else {
                p.next = queue.peek();
            }
        }

        return root;
    }

    /**
     * 不用队列
     */
    private Node last = null, nextStart = null;

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;//上一层链的开头
        while (start != null) {
            last = null;//目前层链的最后一个
            nextStart = null;//目前层链的开头
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node p) {
        //当前链不为空，把p连上
        if (last != null) {
            last.next = p;
        }
        //当前链为空，让p为链开头
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }

}
