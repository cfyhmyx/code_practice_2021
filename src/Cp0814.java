// https://leetcode.com/problems/binary-tree-pruning/

public class Cp0814 {
    public static void main(String args[]) {
    }

    // Main idea: tree, dfs.
    // Time: O(n).
    // Space: O(n).
    public TreeNode pruneTree(TreeNode root) {
        if (helper(root) == 1) return root;
        else return null;
    }

    private int helper(TreeNode cur) {
        if (cur == null) return 0;
        int left = helper(cur.left);
        if (left  == 0) {
            cur.left = null;
        }
        int right = helper(cur.right);
        if (right == 0) {
            cur.right = null;
        }
        if (left == 0 && right == 0 && cur.val == 0) {
            return 0;
        }
        return 1;
    }
}
