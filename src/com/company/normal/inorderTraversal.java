package com.company.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]

 */


public class inorderTraversal {
    public static class TreeNode {
        int val;TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        dfs(root);
        return list;
    }
    public void dfs(TreeNode treeNode){
        if (treeNode == null)
            return;
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
    }
}
