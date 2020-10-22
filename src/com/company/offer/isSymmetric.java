package com.company.offer;
import com.company.*;
/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class isSymmetric {
    /**
     * 首先，每个对称节点本身相同
     * 其次，每个对称节点的左右节点的左节点的左节点等于右节点的右节点
     * 左节点的右节点等于右节点的左节点
     * 所以从根节点的左右节点开始递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return recur(root.left, root.right);
    }
    private boolean recur(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }else if (left != null && right != null){
            if (left.val != right.val){
                return false;
            }else {
                if(recur(left.left,right.right)) {
                    return recur(left.right,right.left);
                }else return false;
            }
        }else {
            return false;
        }
    }
}
