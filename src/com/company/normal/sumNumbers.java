package com.company.normal;

public class sumNumbers {
    /**
     * 129. 求根到叶子节点数字之和
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     * <p>
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     * <p>
     * 计算从根到叶子节点生成的所有数字之和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 1
     * / \
     * 2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * 示例 2:
     * <p>
     * 输入: [4,9,0,5,1]
     * 4
     * / \
     * 9   0
     * / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026.
     *
     * @param root
     * @return
     */

    private int temp = 0;
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            sum += temp * 10 + treeNode.val;
            return;
        }
        temp = temp * 10 + treeNode.val;
        if (treeNode.left != null)
            dfs(treeNode.left);
        if (treeNode.right != null)
            dfs(treeNode.right);
        temp = temp / 10;
    }
}
