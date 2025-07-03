class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;

    public void insert(int value) {

        if (root == null) {
            root = new TreeNode(value);
            System.out.println(value + " inserted as root node.");
        }

        else {
            insertNode(root, value);
        }
    }

    private void insertNode(TreeNode current, int value) {
        if (value < current.data) {
            if (current.left == null) {
                current.left = new TreeNode(value);
                System.out.println(value + " inserted to the left of " + current.data);
            } else {
                insertNode(current.left, value);
            }
        } else if (value > current.data) {
            if (current.right == null) {
                current.right = new TreeNode(value);
                System.out.println(value + " inserted to the right of " + current.data);
            } else {
                insertNode(current.right, value);
            }
        } else {
            System.out.println(value + " already exists in the tree. Duplicates not allowed.");
        }
    }

    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(10);
        bst.insert(30);

        bst.inorderTraversal();
    }
}

