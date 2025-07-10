enum Color {
    RED, BLACK
}

class Node {
    int data;
    Color color;
    Node left, right, parent;

    Node(int data) {
        this.data = data;
        this.color = Color.RED;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class RedBlackTree {
    private Node root;

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.right)
            y.parent.right = x;
        else
            y.parent.left = x;

        x.right = y;
        y.parent = x;
    }

    public void insert(int data) {
        Node node = new Node(data);
        root = bstInsert(root, node);
        fixViolation(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null)
            return node;

        if (node.data < root.data) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    private void fixViolation(Node node) {
        while (node != root && node.parent.color == Color.RED) {
            Node parent = node.parent;
            Node grandparent = parent.parent;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                if (uncle != null && uncle.color == Color.RED) {
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    grandparent.color = Color.RED;
                    node = grandparent;
                } else {
                    if (node == parent.right) {
                        node = parent;
                        leftRotate(node);
                    }

                    parent.color = Color.BLACK;
                    grandparent.color = Color.RED;
                    rightRotate(grandparent);
                }
            } else {
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == Color.RED) {
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    grandparent.color = Color.RED;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        node = parent;
                        rightRotate(node);
                    }

                    parent.color = Color.BLACK;
                    grandparent.color = Color.RED;
                    leftRotate(grandparent);
                }
            }
        }

        root.color = Color.BLACK;
    }

    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.print(root.data + "(" + root.color + ") ");
            inorderHelper(root.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        int[] values = {10, 20, 30, 15, 25, 5};
        for (int val : values) {
            rbt.insert(val);
            System.out.print("After inserting " + val + ": ");
            rbt.inorder();
        }
    }
}

