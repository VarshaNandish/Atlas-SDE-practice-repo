import java.util.*;

public class LeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode sol = new LeetCode();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(4));

        System.out.println("Right Side View: " + sol.rightSideView(root));
    }
}
