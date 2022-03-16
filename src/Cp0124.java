// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class Cp0124 {
    public static void main(String args[]) {
    }

    private int result = -1001;

    // Main idea: tree, recursion.
    // Time: O(n).
    // Space: O(n).
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        result = Math.max(result, left + right + node.val);
        return Math.max(Math.max(left + node.val, right + node.val), node.val);
    }
}
