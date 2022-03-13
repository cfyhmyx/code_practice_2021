// https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class Cp0111 {
    public static void main(String args[]) {
    }

    // Main idea: tree, recursion
    // Time: O(n).
    // Space: O(n).
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right))+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
