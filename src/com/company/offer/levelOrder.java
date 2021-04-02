package com.company.offer;

import com.company.normal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * <p>
     * <p>
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int rear = -1, front = -1;
        int last = 0;
        queue.offer(root);
        ++rear;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            ++front;
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                ++rear;
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                ++rear;
            }
            if (front == last) {
                lists.add(new ArrayList<>(list));
                list.clear();
                last = rear;
            }
        }
        return lists;
    }
}
