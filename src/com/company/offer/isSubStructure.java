package com.company.offer;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A.left != null){
            boolean a = isSubStructure(A.left,B);
            if (a){
                return true;
            }
        }
        if (A.val == B.val){
            if (check(A, B)){
                return true;
            }
        }
        if (A.right != null){
            return isSubStructure(A.right,B);
        }
        return false;
    }

    /**
     * 判断一个树是否是另一个树的一部分；
     * @return
     */
    private boolean check(TreeNode A, TreeNode B){
        if(B.left != null){
            if (A.left == null){
                return false;
            }else {
                boolean a = check(A.left,B.left);
                if (!a)
                    return false;
            }
        }

        if (A.val != B.val)
            return false;

        if (B.right != null){
            if (A.right == null){
                return false;
            }else {
                return check(A.right,B.right);
            }
        }
        return true;
    }
}
