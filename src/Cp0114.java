// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class Cp0114 {
    public static void main(String[] args) {
    }

    // Main idea: tree, recursion
    // Time: O(n).
    // Space: O(n).
    public void flatten(TreeNode root) {
        helper(root, null);
    }

    public TreeNode helper(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = helper(root.right, pre);
        pre = helper(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }
}
