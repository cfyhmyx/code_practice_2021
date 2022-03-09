// https://leetcode.com/problems/symmetric-tree/

public class Cp0101 {
    public static void main(String args[]) {
    }

    // Main idea: tree, recursion
    // Time: O(n).
    // Space: O(n).
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right == null || left.val != right.val) {
            return false;
        } else {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
}
