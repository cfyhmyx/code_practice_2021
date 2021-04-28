// https://leetcode.com/problems/distribute-coins-in-binary-tree/

public class Cp0979 {
    public static void main(String args[]) {
    }

    private int res = 0;

    // Main idea: tree, post-order traversal.
    // Time: O(n).
    // Space: O(1).
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
