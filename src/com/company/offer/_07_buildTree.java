package com.company.offer;

import com.company.normal.TreeNode;

/**
 * 剑指 Offer 07. 重建二叉树
 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 */

public class _07_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 返回中序遍历数组中，对应节点index
     * @param inorder
     * @param a
     * @return
     */
    private int index(int[] inorder, int a) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == a) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param a 前序遍历数组左边
     * @param b 前序遍历数组右边
     * @param c 中序遍历数组左边
     * @param d 中序遍历数组右边
     * @param preorder 前序遍历数组
     * @param inorder 中序遍历数组
     * @return 建立好的节点
     */
    private TreeNode build(int a, int b, int c, int d, int[] preorder, int[] inorder) {
        if (a > b || a < 0 || a > preorder.length || c > d || c > preorder.length || d < 0) {
            return null;
        }
        if (a == b) {
            //只剩一个节点
            return new TreeNode(preorder[a]);
        }
        //找到中序遍历数组中节点下标
        int index = index(inorder, preorder[a]);
        TreeNode treeNode = new TreeNode(preorder[a]);
        treeNode.left = build(
                a + 1,
                a + index - c,
                c,
                index - 1,
                preorder,
                inorder
        );
        treeNode.right = build(
                a + index - c + 1,
                b,
                index + 1,
                d,
                preorder,
                inorder
        );
        return treeNode;
    }
}
