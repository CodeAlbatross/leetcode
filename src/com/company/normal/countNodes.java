package com.company.normal;

public class countNodes {
    /**
     * 222. 完全二叉树的节点个数
     * 给出一个完全二叉树，求出该树的节点个数。
     * <p>
     * 说明：
     * <p>
     * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * 1
     * / \
     * 2   3
     * / \  /
     * 4  5 6
     * <p>
     * 输出: 6
     */
    private int count = 0;

    public int countNodes(TreeNode root) {
        int count = 0;
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        ++count;
        dfs(root.right);
    }

    /**
     * 利用完全二叉树的性质解题
     *
     * @param root
     * @return
     */
    public int countNodes_2(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        int height = level(root);
        while (root != null) {

            if (level(root.right) == height - 1) {
                count += (1 << height - 1);
                root = root.right;
            } else {
                count += (1 << height - 2);
                root = root.left;
            }
            height--;
        }

        return count;
    }

    private int level(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            ++level;
        }
        return level;
    }

}
