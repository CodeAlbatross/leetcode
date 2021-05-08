package com.company.IntroductionToAlgorithms;

public class RedBlackTree {
    public static final boolean BLACK = true;
    public static final boolean RED = false;
    Node root;

    public RedBlackTree() {
    }

    public RedBlackTree(Node root) {
        this.root = root;
    }

    //找到指定节点插入位置（返回父节点）
    private Node findLocation(Node root, Node node, Node pre) {
        if (root == null) {
            return pre;
        }
        if (node.value < root.value) {
            return findLocation(root.leftChildren, node, root);
        } else if (node.value > root.value) {
            return findLocation(root.rightChildren, node, root);
        } else {
            return root;
        }
    }

    //右旋
    public Node rightRotate(Node node) {
        if (node.leftChildren == null) {
            return node;
        }
        Node parent = node.parent;
        Node leftChildren = node.leftChildren;
        node.parent = leftChildren;
        node.leftChildren = leftChildren.rightChildren;
        leftChildren.rightChildren = node;
        leftChildren.parent = parent;
        if (parent != null) {
            if (parent.value < leftChildren.value) {
                parent.rightChildren = leftChildren;
            } else {
                parent.leftChildren = leftChildren;
            }
        }
        return leftChildren;
    }

    //左旋
    public Node leftRotate(Node node) {
        if (node.rightChildren == null) {
            return node;
        }
        Node parent = node.parent;
        Node rightChildren = node.rightChildren;
        node.parent = rightChildren;
        node.rightChildren = rightChildren.leftChildren;
        rightChildren.leftChildren = node;
        rightChildren.parent = parent;
        if (parent != null) {
            if (parent.value < rightChildren.value) {
                parent.rightChildren = rightChildren;
            } else {
                parent.leftChildren = rightChildren;
            }
        }
        return rightChildren;
    }

    public void changeColor(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        boolean temp;
        temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    //得到前驱节点
    private Node getPostNode(Node node) {
        Node leftChildren = node.leftChildren;

        if (node == null) {
            return null;
        }
        if (leftChildren == null) {
            return node;
        } else {
            Node p = leftChildren;
            Node r = leftChildren.rightChildren;
            while (r != null) {
                p = r;
                r = r.rightChildren;
            }
            return p;
        }
    }

    public void insert(Node node) {
        Node parent = findLocation(root, node, null);
        if (parent == null) {
            root = node;
        } else {
            if (node.value > parent.value) {
                parent.rightChildren = node;
            } else if (node.value < parent.value) {
                parent.leftChildren = node;
            }
            node.parent = parent;
        }
        insert1(node);
    }

    //情境一:node为跟节点时，颜色设为黑,否则将其插入到相应位置
    public void insert1(Node node) {
        if (node.parent == null) {
            node.color = BLACK;
        } else {
            insert2(node);
        }
    }

    //如果parent为黑色，树本身是平衡的（插入的节点为红色），不需要转换
    private void insert2(Node node) {
        if (node.parent.color == BLACK) {
            return;
        } else {
            insert3(node);
        }
    }

    //如果parent是红色(不是跟节点，有父亲)，uncle也是红色，则将parent、uncle和grandfather交换颜色，然后重新使grandfather平衡
    private void insert3(Node node) {
        Node grandparent = node.getGrandparent();
        Node uncle = node.getUncle();
        if (uncle != null && uncle.color == RED) {
            node.parent.color = BLACK;
            uncle.color = BLACK;
            grandparent.color = RED;
            insert1(grandparent);
        } else {
            insert4(node);
        }
    }

    //如果parent是红色，uncle是null（不可能是黑色），parent为grandparent的左（右）节点，node为parent的右（左）节点，则左（右）旋，转到情景五
    private void insert4(Node node) {
        Node grandparent = node.getGrandparent();
        if (node.parent == grandparent.leftChildren && node == node.parent.rightChildren) {
            leftRotate(node.parent);
        } else if (node.parent == grandparent.rightChildren && node == node.parent.leftChildren) {
            rightRotate(node.parent);
        }
        insert5(node);
    }

    //如果parent是红色，uncle是null(不可能是黑色)，parent为grandparent的左（右）节点，node为parent的左（右）节点，则右旋,parent和grandparent颜色互换
    private void insert5(Node node) {
        Node grandparent = node.getGrandparent();
        node.parent.color = BLACK;
        grandparent.color = RED;
        if (node.parent == grandparent.leftChildren) {
            if (grandparent.parent == null) {
                root = rightRotate(grandparent);
            } else {
                rightRotate(grandparent);
            }
        } else {
            //如果为跟节点，左旋后需要为root重新赋值
            if (grandparent.parent == null) {
                root = leftRotate(grandparent);
            } else {
                leftRotate(grandparent);
            }
        }
    }


    private void replace(Node target, Node replacement) {
        if (target == null) {
            return;
        }
        if (target == target.parent.leftChildren) {
            target.parent.leftChildren = replacement;
        } else {
            target.parent.rightChildren = replacement;
        }
    }

    private void delete(Node node) {
        if (node == null) {
            return;
        }
        if (node == node.parent.leftChildren) {
            node.parent.leftChildren = null;
        } else {
            node.parent.rightChildren = null;
        }
    }

    public void remove(Node node) {
        if (node == null) {
            return;
        }
        //查找待删除的节点
        Node target = findLocation(root, node, null);
        //未找到该节点
        if (target.value != node.value) {
            return;
        } else {
            if (target.leftChildren != null && target.rightChildren != null) {
                //有两个非空节点时，用前驱节点的值替换，相当与删除前驱节点
                Node postNode = getPostNode(target);
                target.value = postNode.value;
                //前驱节点至多有1个子节点
                remove1(postNode);
            } else {
                remove1(target);
            }
        }

    }

    //先用孩子节点替换，然后平衡新树(能进到该方法只有两种可能：1.删除节点有一个红色孩子 2.删除节点无孩子)
    private void remove1(Node node) {
        Node children = node.leftChildren == null ? node.rightChildren : node.leftChildren;
        if (children != null) {
            if (node.parent == null) {      //删除节点为根节点
                root = children;
            } else {
                replace(node, children);
            }
            if (node.color == BLACK) {
                children.color = BLACK;
            }
        } else {
            if (node.parent == null) {
                root = null;
            } else {
                //当删除节点为黑色且没有孩子节点时，必须先平衡树，再删除节点
                rebalance1(node);
                delete(node);
            }
        }
    }

    //R代表删除节点，P代表R父节点，S代表R兄弟节点，SL代表S左孩子，SR代表右孩子
    //R为黑色,子节点为黑色（两个叶子节点），S为红色,P左（右）旋，P,S互换颜色，转到rebalance4
    private void rebalance1(Node node) {
        if (node.parent != null) {  //这里加上这个判断是为了rebalance5递归调用时有一个出口
            Node sibling = node.getSibling();
            if (sibling.color == RED) {
                changeColor(node.parent, sibling);
                if (node == node.parent.leftChildren) {
                    leftRotate(node.parent);
                } else {
                    rightRotate(node.parent);
                }
                rebalance4(node);
            } else {
                rebalance2(node);
            }
        }
    }

    //R为黑，S为黑，SR为红，SL和P任意，P,S互换颜色，P左（右）旋，SR变黑
    private void rebalance2(Node node) {
        Node sibling = node.getSibling();
        Node sr = sibling.rightChildren;
        if (sr.color == RED) {
            changeColor(node.parent, sibling);
            if (node == node.parent.leftChildren) {
                leftRotate(node.parent);
            } else {
                rightRotate(node.parent);
            }
            sr.color = BLACK;
        } else {
            rebalance3(node);
        }
    }

    //R为黑，S为黑，SR为黑，SL为红，P任意，S和SL互换颜色，S左（右）旋，转到rebalance2
    private void rebalance3(Node node) {
        Node sibling = node.getSibling();
        Node sl = sibling.leftChildren;
        if (sl.color == RED) {
            changeColor(sibling, sl);
            rightRotate(sibling);
            rebalance2(node);
        } else {
            rebalance4(node);
        }
    }

    //R为黑，S为黑，SR为黑，SL为黑，P为红，P,S互换颜色
    private void rebalance4(Node node) {
        if (node.parent.color == RED) {
            changeColor(node.parent, node.getSibling());
        } else {
            rebalance5(node);
        }
    }

    //R为黑，S为黑，SR为黑，SL为黑，P为黑，S变为黑色，平衡P
    private void rebalance5(Node node) {
        node.getSibling().color = RED;
        rebalance1(node.parent);
    }


    static class Node {
        int value;
        boolean color;
        Node parent, leftChildren, rightChildren;

        public Node(int value) {
            this.value = value;
        }

        public Node getGrandparent() {
            if (this.parent == null) {
                return null;
            }
            return this.parent.parent;
        }

        public Node getUncle() {
            if (this.parent == null) {
                return null;
            }
            Node grandparent;
            if ((grandparent = this.getGrandparent()) == null) {
                return null;
            }
            return this.parent == grandparent.leftChildren ? grandparent.rightChildren : grandparent.leftChildren;
        }

        public Node getSibling() {
            if (this.parent == null) {
                return null;
            }
            return this == this.parent.leftChildren ? this.parent.rightChildren : this.parent.leftChildren;
        }
    }

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        Node node14;
        Node node9;
        Node node5;

        redBlackTree.insert(new Node(1));
        redBlackTree.insert(node5 = new Node(5));
        redBlackTree.insert(new Node(6));
        redBlackTree.insert(new Node(7));
        redBlackTree.insert(new Node(8));
        redBlackTree.insert(node9 = new Node(9));
        redBlackTree.insert(new Node(10));
        redBlackTree.insert(new Node(11));
        redBlackTree.insert(new Node(12));
        redBlackTree.insert(new Node(13));
        redBlackTree.insert(node14 = new Node(14));
        redBlackTree.insert(new Node(15));

        midDfs(redBlackTree.root);

        //redBlackTree.remove(node14);
        redBlackTree.remove(node9);
        //redBlackTree.remove(node5);

        midDfs(redBlackTree.root);


    }

    public static void midDfs(Node node){
        if (node == null)
            return;
        midDfs(node.leftChildren);
        System.out.print(!node.color ? "red" : "black");
        System.out.println("    "+node.value);
        midDfs(node.rightChildren);
    }
}
