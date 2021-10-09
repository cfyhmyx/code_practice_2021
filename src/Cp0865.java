public class Cp0865 {
    public static void main(String args[]) {
    }

    private int deepest = 0;
    private TreeNode lca;

    // Main idea: tree, post order.
    // Time: O(n).
    // Space: O(n).
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) {
            return depth;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == deepest && right == deepest) {
            lca = node;
        }
        return Math.max(left, right);
    }
}
