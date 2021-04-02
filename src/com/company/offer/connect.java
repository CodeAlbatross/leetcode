package com.company.offer;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class connect {
    public Node connect(Node root) {

        if (root == null)
            return null;
        Node mostLeft = root;//保存当前层的最左边节点
        while (mostLeft.left != null) {
            Node start = mostLeft;//start链接当前层的每个节点
            while (start != null) {
                //连接当前节点左右子节点
                start.left.next = start.right;
                //链接当前节点右孩子和下一节点左孩子（如果有下一节点）
                if (start.next != null) {
                    start.right.next = start.next.left;
                }
                start = start.next;
            }
            mostLeft = mostLeft.left;
        }
        return root;
    }
}
