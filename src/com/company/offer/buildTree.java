package com.company.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }
    private int index(int[] inorder, int a){
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == a){
                return i;
            }
        }
        return -1;
    }
    private TreeNode build(int a, int b, int c, int d, int[] preorder, int[] inorder){
        if (a > b || a < 0 || a > preorder.length || c > d || c > preorder.length || d < 0 ){
            return null;
        }
        if (a == b){
            return new TreeNode(preorder[a]);
        }
        int index = index(inorder,preorder[a]);
        TreeNode treeNode = new TreeNode(preorder[a]);
        treeNode.left = build(a+1, a+index-c, c, index-1, preorder, inorder);
        treeNode.right = build(a+index-c+1, b, index+1, d, preorder, inorder);
        return treeNode;
    }
}
