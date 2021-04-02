package com.company.normal;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int front = -1, rear = -1;
        int last = 0;
        queue.offer(root);
        ++rear;
        TreeNode p;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            p = queue.poll();
            ++front;
            if (p != null) {
                sb.append((char) p.val);
            } else {
                sb.append("##");
            }
            if (p != null) {
                queue.offer(p.left);
                ++rear;
                queue.offer(p.right);
                ++rear;
            }
            if (front == last) {
                if (!sb.toString().equals(sb.reverse().toString())) {
                    return false;
                }
                sb = new StringBuilder();
                last = rear;
            }
        }
        return true;
    }
}
