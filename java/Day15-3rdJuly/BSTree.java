
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;}
}

public class BSTree {
    Node root; // Root of the BST

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.data)
            node.left = insertNode(node.left, value);

        else if (value > node.data)
            node.right = insertNode(node.right, value);

        return node;
    }

    public Node deleteNode(Node node, int key) {

        if (node == null) return null;

        if (key < node.data) {

            node.left = deleteNode(node.left, key); // Go left

        } else if (key > node.data) {

            node.right = deleteNode(node.right, key); // Go right

        } else {

            if (node.left == null && node.right == null) {
                return null;
            }

            else if (node.left == null) {
                return node.right;
            }

            else if (node.right == null) {
                return node.left;
            }

            else {
                Node successor = findMin(node.right); // Find smallest in right subtree
                node.data = successor.data;           // Replace with successor's data
                node.right = deleteNode(node.right, successor.data); // Delete successor
            }
        }

        return node;
    }


    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void displayInorder(Node node) {
        if (node != null) {
            displayInorder(node.left);
            System.out.print(node.data + " ");
            displayInorder(node.right);
        }
    }


    public static void main(String[] args) {

        BSTree bst = new BSTree();

        bst.insert(50);

        bst.insert(30);

        bst.insert(70);

        bst.insert(20);

        bst.insert(40);

        bst.insert(60);

        bst.insert(80);

        System.out.println("Inorder before deletion:");

        bst.displayInorder(bst.root);  // Expected: 20 30 40 50 60 70 80

        System.out.println();

        System.out.println("Deleting node 30...");

        bst.root = bst.deleteNode(bst.root, 30);

        System.out.println("Inorder after deletion:");

        bst.displayInorder(bst.root);

    }

}

