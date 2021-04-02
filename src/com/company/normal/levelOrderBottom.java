package com.company.normal;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

public class levelOrderBottom {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int front = -1, rear = -1;
        int last = 0;
        queue.offer(root);
        ++rear;
        TreeNode p;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            p = queue.poll();
            ++front;

            if (p != null) {
                list.add(p.val);
                queue.offer(p.left);
                ++rear;
                queue.offer(p.right);
                ++rear;
            }
            if (front == last) {
                if (!list.isEmpty())
                    lists.add(list);
                list = new ArrayList<>();
                last = rear;
            }
        }
        Collections.reverse(lists);
        return lists;

    }
}
