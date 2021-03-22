package com.company.offer;

import com.company.normal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _54_kthLargest {
    List<Integer> list = new LinkedList<>();
    int ret;
    int count;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return ret;
    }
    private void dfs(TreeNode root, int k){
        if (root == null)
            return;
        dfs(root.right, k);
        count++;
        if (count == k)
        {
            ret = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
