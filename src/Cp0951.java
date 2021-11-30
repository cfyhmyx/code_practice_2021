// https://leetcode.com/problems/flip-equivalent-binary-trees/

public class Cp0951 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, recursion.
    // Time: O(n).
    // Space: O(log(n)).
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }
        if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
            return true;
        }
        return flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
    }
}
