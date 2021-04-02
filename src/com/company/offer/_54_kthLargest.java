package com.company.offer;

import com.company.normal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 反向中序遍历到第k个节点
 */
public class _54_kthLargest {
    List<Integer> list = new LinkedList<>();
    int ret;
    int count;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ret;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null)
            return;
        dfs(root.right, k);
        count++;
        if (count == k) {
            ret = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
