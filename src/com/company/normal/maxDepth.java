package com.company.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 */
public class maxDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int front = -1, rear = -1;
        int last = 0, level = 0;
        queue.offer(root);
        ++rear;
        TreeNode p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            ++front;

            if (p != null) {
                queue.offer(p.left);
                ++rear;
                queue.offer(p.right);
                ++rear;
            }
            if (front == last) {
                ++level;
                last = rear;
            }
        }
        return level;
    }
}
