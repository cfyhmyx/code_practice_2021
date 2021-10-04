// https://leetcode.com/problems/maximum-average-subtree/

public class Cp1120 {
    public static void main(String args[]) {
    }

    private double result = 0;

    // Main idea: tree, post order.
    // Time: O(n).
    // Space: O(n).
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return result;
    }

    private int[] helper(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int sum = node.val + left[0] + right[0];
        int num = 1 + left[1] + right[1];
        result = Math.max(result, ((double)sum) / num);
        return new int[]{sum, num};
    }
}
