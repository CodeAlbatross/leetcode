package com.company.IntroductionToAlgorithms;

import com.company.normal.TreeNode;

import java.util.ArrayList;
import java.util.List;

//判断BST
public class DetermineBST {
    public static List<Integer> list;
    public static void main(String[] args) {
        list = new ArrayList<>();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(func(root));
    }
    public static boolean func(TreeNode treeNode){
        if (treeNode == null)
            return true;
        boolean b1 = func(treeNode.left);
        if (list.isEmpty()){
            list.add(treeNode.val);
        }else {
            if (treeNode.val <= list.get(list.size()-1)){
                return false;
            }
        }
        list.add(treeNode.val);
        boolean b2 = func(treeNode.right);
        return b1 && b2;
    }
}
