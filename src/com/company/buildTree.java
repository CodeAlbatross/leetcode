package com.company;

import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class buildTree {

    public Main.TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        if (inorder.length == 1)
            return new Main.TreeNode(inorder[0]);

        return build(0,inorder.length-1,0, postorder.length-1, inorder, postorder);

    }
    public static int index(int[] inorder, int a){
        for (int i = 0; i< inorder.length; i++){
            if (a == inorder[i])
                return i;
        }
        return -1;
    }

    /**
     * 分制法
     * @param a 左边子序列开头
     * @param b 左边子序列结尾
     * @param c 右边子序列开头
     * @param d 右边子序列结尾
     * @param inorder
     * @param postorder
     * @return
     */
    private static Main.TreeNode build(int a, int b,int c, int d, int[] inorder, int[] postorder) {
        if (a > b || a > inorder.length || a < 0 || b < 0 || d < 0 || d > inorder.length)
            return null;
        if (a == b)
            return new Main.TreeNode(inorder[a]);
        int index = index(inorder, postorder[d]);
        Main.TreeNode treeNode = new Main.TreeNode(postorder[d]);
        treeNode.left = build(a,index-1, c, index - a + c-1,inorder,postorder);
        treeNode.right = build(index+1,b, c + index - a,d-1,inorder,postorder);
        return treeNode;
    }
}