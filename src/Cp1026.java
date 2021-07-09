// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

public class Cp1026 {
    public static void main(String args[]) {
    }

    // Main idea: tree, preorder.
    // Time: O(n).
    // Space: O(n).
    public int maxAncestorDiff(TreeNode root) {
        return helper(root.val, root.val, root);
    }

    private int helper(int min, int max, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int localMax = Math.max(Math.abs(min-node.val), Math.abs(max-node.val));
        int newMin = Math.min(min, node.val);
        int newMax = Math.max(max, node.val);
        int left = helper(newMin, newMax, node.left);
        int right = helper(newMin, newMax, node.right);
        return Math.max(localMax, Math.max(left, right));
    }
}
