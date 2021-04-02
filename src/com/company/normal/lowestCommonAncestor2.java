package com.company.normal;

public class lowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null) {//p和q分别在root左右
                return root;
            } else if (lNode == null) {//p和q在root右侧
                return rNode;
            } else return lNode;//p和q在root左侧
        }
        return null;
    }
}
