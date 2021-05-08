package com.company.offer;

import com.company.normal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _34_pathSum {
    int sum;
    int target;
    List<Integer> list;
    List<List<Integer>> lists;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        sum = 0;
        list = new ArrayList<>();
        lists = new ArrayList<>();
        this.target = target;
        dfs(root);
        return lists;
    }
    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (target == sum + root.val){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
        }
        list.add(root.val);
        sum+=root.val;
        dfs(root.left);
        dfs(root.right);
        list.remove(list.size()-1);
        sum-=root.val;
    }
}
