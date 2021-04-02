package com.company.offer;

import com.company.normal.TreeNode;

import java.util.*;

public class levelOrder2 {
    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int rear = -1, front = -1;
        int last = 0;
        int level = 1;
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
                if ((level & 1) == 0) {
                    List<Integer> temp = new ArrayList<>(list);
                    Collections.reverse(temp);
                    lists.add(new ArrayList<>(temp));
                } else {
                    lists.add(new ArrayList<>(list));
                }
                list.clear();
                last = rear;
                ++level;
            }
        }
        return lists;
    }
}
