package com.company;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class sumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return sum;
        if (root.left == null && root.right == null){
            return root.val;
        }
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode treeNode){
        if (treeNode.left == null && treeNode.right == null)
            return;
        if ((treeNode.left != null && treeNode.left.left == null) && treeNode.left.right == null){
            sum+=treeNode.left.val;
        }
        if (treeNode.left != null)
            dfs(treeNode.left);
        if (treeNode.right != null)
            dfs(treeNode.right);

    }
}
