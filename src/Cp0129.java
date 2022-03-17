// https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class Cp0129 {
    public static void main(String args[]) {
    }

    private int sum = 0;

    // Main idea: tree, recursion.
    // Time: O(n).
    // Space: O(n).
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode node, int path) {
        if (node == null) return;
        path = 10 * path + node.val;
        if (node.left == null && node.right == null) {
            sum += path;
            return;
        }
        helper(node.left, path);
        helper(node.right, path);
    }
}
