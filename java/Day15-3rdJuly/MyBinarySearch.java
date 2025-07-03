
class MyNode {
    int value;
    MyNode left, right;

    MyNode(int val) {
        value = val;
        left = right = null;
    }
}

public class MyBinarySearch {
    MyNode root;

    public MyBinarySearch() {

        root = new MyNode(50);
        root.left = new MyNode(30);
        root.right = new MyNode(70);
        root.left.left = new MyNode(20);
        root.left.right = new MyNode(40);
        root.right.left = new MyNode(60);
        root.right.right = new MyNode(80);
    }

    public boolean search(int key) {
        return searchInTree(root, key);
    }

    private boolean searchInTree(MyNode node, int key) {

        if (node == null) return false;
        if (node.value == key) return true;

        if (key < node.value)
            return searchInTree(node.left, key);
        else
            return searchInTree(node.right, key);
    }

    public static void main(String[] args) {

        MyBinarySearch tree = new MyBinarySearch();

        int key1 = 40;
        System.out.println("Search " + key1 + ": " + (tree.search(key1) ? "Found" : "Not Found"));

        int key2 = 100;
        System.out.println("Search " + key2 + ": " + (tree.search(key2) ? "Found" : "Not Found"));

    }
}

