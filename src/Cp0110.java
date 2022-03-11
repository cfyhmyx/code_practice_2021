// https://leetcode.com/problems/balanced-binary-tree/

public class Cp0110 {
    public static void main(String args[]) {
    }

    // Main idea: tree, recursion
    // Time: O(n).
    // Space: O(n).
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
