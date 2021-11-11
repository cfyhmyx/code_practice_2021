// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

public class Cp1038 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(n).
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode node, int parentSum) {
        if (node == null) return parentSum;
        node.val += helper(node.right, parentSum);
        return helper(node.left, node.val);
    }
}
