package com.company;
/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 */

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
    public int minDepth(Main.TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<Main.TreeNode> queue  = new LinkedList<>();
        int front = -1,rear = -1;
        int last = 0,level = 0;
        queue.offer(root);
        ++rear;
        Main.TreeNode p;
        while (!queue.isEmpty()){
            p = queue.poll();
            ++front;

            if (p != null){
                if ( p.left == null && p.right == null)
                    return level+1;
                queue.offer(p.left);
                ++rear;
                queue.offer(p.right);
                ++rear;
            }
            if (front == last){
                ++level;
                last = rear;
            }
        }
        return level;
    }
}
