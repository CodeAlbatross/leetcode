package com.company;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class sortedArrayToBST {
    public Main.TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new Main.TreeNode(nums[0]);
        Main.TreeNode treeNode = new Main.TreeNode(nums[(nums.length-1)/2]);
        creat(nums,0, (nums.length-1)/2-1, treeNode);
        creat(nums,(nums.length-1)/2+1,nums.length-1,treeNode);
        return treeNode;
    }
    public void creat(int[] nums, int start, int end, Main.TreeNode treeNode){
        if (start > end)
            return;
        if (nums[(start+end)/2] < treeNode.val){
            treeNode.left = new Main.TreeNode(nums[(start+end)/2]);
            creat(nums,start,(start+end)/2-1,treeNode.left);
            creat(nums,(start+end)/2+1,end,treeNode.left);
        }else {
            treeNode.right = new Main.TreeNode(nums[(start+end)/2]);
            creat(nums,start,(start+end)/2-1,treeNode.right);
            creat(nums,(start+end)/2+1,end,treeNode.right);
        }

    }

}
