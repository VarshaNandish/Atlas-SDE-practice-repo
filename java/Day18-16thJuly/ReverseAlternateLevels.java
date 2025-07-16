import java.util.*;

class TreeNode {
    char key;
    TreeNode left, right;

    public TreeNode(char key) {
        this.key = key;
        left = right = null;
    }
}

class ReverseAlternateLevels {
    TreeNode root;

    void printAlternateLevelReverse(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Character> levelNodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode current = q.poll();
                levelNodes.add(current.key);

                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }

            if (reverse) {
                Collections.reverse(levelNodes);
            }

            for (char ch : levelNodes) {
                System.out.print(ch + " ");
            }
            System.out.println();

            reverse = !reverse;
        }
    }

    public static void main(String[] args) {
        ReverseAlternateLevels tree = new ReverseAlternateLevels();

        tree.root = new TreeNode('A');
        tree.root.left = new TreeNode('B');
        tree.root.right = new TreeNode('C');
        tree.root.left.left = new TreeNode('D');
        tree.root.left.right = new TreeNode('E');
        tree.root.right.left = new TreeNode('F');
        tree.root.right.right = new TreeNode('G');
        tree.root.left.left.left = new TreeNode('H');
        tree.root.left.left.right = new TreeNode('I');
        tree.root.left.right.left = new TreeNode('J');
        tree.root.right.left.left = new TreeNode('L');
        tree.root.right.left.right = new TreeNode('M');
        tree.root.right.right.left = new TreeNode('N');
        tree.root.left.left.left.left = new TreeNode('P');
        tree.root.left.left.left.right = new TreeNode('Q');
        tree.root.right.right.left.left = new TreeNode('Y');
        tree.root.right.right.left.right = new TreeNode('Z');

        tree.printAlternateLevelReverse(tree.root);
    }
}
