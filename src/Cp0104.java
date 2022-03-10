// https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class Cp0104 {
    public static void main(String args[]) {
    }

    // Main idea: tree, recursion
    // Time: O(n).
    // Space: O(n).
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
