// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class Cp0236 {
    public static void main(String args[]) {
    }

    // Main idea: tree, post order.
    // Time: O(n).
    // Space: O(n).
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        if (root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

}
