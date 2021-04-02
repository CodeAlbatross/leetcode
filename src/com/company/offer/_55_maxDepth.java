package com.company.offer;

import com.company.normal.TreeNode;

public class _55_maxDepth {
    //二叉树最大深度
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
