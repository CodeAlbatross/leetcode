package com.company.offer;

import com.company.normal.TreeNode;

public class _55_isBalanced {
    //判断平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l == -1 || r == -1)
            return -1;
        int abs = Math.abs(l - r);
        if (abs <= 1)
            return Math.max(l, r) + 1;
        return -1;
    }
}
