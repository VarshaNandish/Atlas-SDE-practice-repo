import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class ExtremeNodesDisplay {

    public static void printEdgeNodesPerLevel(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node first = null, last = null;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (i == 0)
                    first = current;
                if (i == levelSize - 1)
                    last = current;

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }

            if (first == last) {
                System.out.println(first.data);
            } else {
                System.out.println(first.data + " " + last.data);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(22);
        root.right = new Node(33);
        root.left.left = new Node(44);
        root.left.right = new Node(55);
        root.right.right = new Node(66);
        root.left.left.left = new Node(77);
        root.right.right.left = new Node(100);
        root.right.right.right = new Node(114);

        System.out.println("Leftmost and Rightmost nodes at each level:");
        printEdgeNodesPerLevel(root);
    }
}

