package com.company;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class hasPathSum {
    boolean aBoolean = false;
    public boolean hasPathSum(Main.TreeNode root, int sum) {
        if (root == null)
            return false;
        dfs(root,sum,0);
        return aBoolean;
    }
    public void dfs(Main.TreeNode treeNode, int sum, int temp){
        if (treeNode == null){
            return;
        }
        if (treeNode.right == null && treeNode.left == null){
            if (temp+treeNode.val == sum){
                aBoolean = true;
            }
            return;
        }
        if (treeNode.left != null){
            dfs(treeNode.left, sum, temp+treeNode.val);
        }
        if (treeNode.right != null){
            dfs(treeNode.right, sum, temp+treeNode.val);
        }
    }
}
