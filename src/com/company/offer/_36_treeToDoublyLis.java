package com.company.offer;

public class _36_treeToDoublyLis {
    private Node pre = null;//递归访问节点的前驱节点,访问节点的前驱节点（左节点）指向它，他的后驱节点（右节点）指向当前节点
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return head;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null)
            return;
        dfs(root.left);
        if (pre == null) {
            pre = root;
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        dfs(root.right);
    }
}
