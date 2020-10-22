package com.company;
/**
 * 后序遍历
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal {
    static List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        dfs(root);
        return list;
    }
    public static void dfs(TreeNode treeNode){
        if (treeNode.left != null)
            dfs(treeNode.left);
        if (treeNode.right != null)
            dfs(treeNode.right);
        list.add(treeNode.val);
    }

    /**
     * 非递归
     */
    public List<Integer> postorderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        do {
            TreeNode treeNode = stack.peek();
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }else if (treeNode.right != null){
                stack.push(treeNode.right);
            }else {
                list.add(treeNode.val);

                stack.pop();
            }
        }while (!stack.empty());
       return list;
    }
}
