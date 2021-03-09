package com.company.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 */
public class findMode {
    // 用 base 记录当前的数字，
    // 用 count 记录当前数字重复的次数，
    // 用 maxCount来维护已经扫描过的数当中出现最多的那个数字的出现次数，
    // 用 answer 数组记录出现的众数
    int count = 0, base = 0, maxCount = 0;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[1];
        MorrisIn(root);
        int[] answer = new int[list.size()];
        for (int i =0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    /**
     * Morris 中序遍历的一个重要步骤就是寻找当前节点的前驱节点，并且 Morris 中序遍历寻找下一个点始终是通过转移到 right 指针指向的位置来完成的。
     *
     * 如果当前节点没有左子树，则遍历这个点，然后跳转到当前节点的右子树。
     * 如果当前节点有左子树，那么它的前驱节点一定在左子树上，我们可以在左子树上一直向右行走，找到当前点的前驱节点。
     *   如果前驱节点没有右子树，就将前驱节点的 right 指针指向当前节点。
     *       这一步是为了在遍历完前驱节点后能找到前驱节点的后继，也就是当前节点。
     *   如果前驱节点的右子树为当前节点，说明前驱节点已经被遍历过并被修改了 right 指针，
     *       这个时候我们重新将前驱的右孩子设置为空，遍历当前的点，然后跳转到当前节点的右子树。
     *
     * @param root
     */
    public void MorrisIn(TreeNode root){
        if (root == null)
            return;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            pre = cur.left;
            if (pre != null){
                while (pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    pre.right = null;
                }
            }
            //System.out.println(cur1.val);
            if (base == cur.val){
                count++;
            }else {
                base = cur.val;
                count = 1;
            }
            if (count == maxCount){
                list.add(base);
            }else if (count > maxCount){
                maxCount = count;
                list.clear();
                list.add(base);
            }
            cur = cur.right;
        }
    }
}
