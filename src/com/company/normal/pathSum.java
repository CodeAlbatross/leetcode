package com.company.normal;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null)
            return lists;
        dfs(root, sum, 0);
        return lists;

    }

    public void dfs(TreeNode treeNode, int sum, int temp) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.right == null && treeNode.left == null) {
            if (temp + treeNode.val == sum) {
                list.add(treeNode.val);
                lists.add(new ArrayList<>(list));//深拷贝，如果直接add list，当list中的值变化时lists也会变化
                list.remove(list.size() - 1);
            }
            return;
        }
        if (treeNode.left != null) {
            list.add(treeNode.val);
            dfs(treeNode.left, sum, temp + treeNode.val);
            list.remove(list.size() - 1);
        }
        if (treeNode.right != null) {
            list.add(treeNode.val);
            dfs(treeNode.right, sum, temp + treeNode.val);
            list.remove(list.size() - 1);
        }
    }
}
