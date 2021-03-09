package com.company.normal;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class getMinimumDifference {
    private int result=Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return result;
    }
    private void dfs(TreeNode treeNode){
        if (treeNode.left != null)
            dfs(treeNode.left);
        if (pre != null){
            result = Math.min(Math.abs(treeNode.val-pre.val),result);
        }
        pre = treeNode;
        if (treeNode.right != null)
            dfs(treeNode.right);
    }
}
