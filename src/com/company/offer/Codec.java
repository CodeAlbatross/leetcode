package com.company.offer;

import com.company.normal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        list.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (treeNode == null) {
                list.add(null);
                continue;
            } else {
                list.add(treeNode.val);
            }
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                list.remove(i);
            } else {
                break;
            }
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        root.left = treeCreate(1, strs);
        root.right = treeCreate(2, strs);
        int a = 0;
        return root;
    }

    private TreeNode treeCreate(int begin, String[] strs) {
        if (begin >= strs.length || strs[begin].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[begin]));
        int n = 0;
        for (int i = 0; i < begin; i++) {
            if (strs[i].equals("null")) {
                ++n;
            }
        }
        root.left = treeCreate((begin - n) * 2 + 1, strs);
        root.right = treeCreate((begin - n) * 2 + 2, strs);


        return root;

    }
}