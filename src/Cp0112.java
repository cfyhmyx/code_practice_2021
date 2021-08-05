// https://leetcode.com/problems/path-sum/

public class Cp0112 {
    public static void main(String args[]) {
    }

    // Main idea: tree.
    // Time: O(n).
    // Space: O(log(n)).
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return sum-root.val == 0;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
