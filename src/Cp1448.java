// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

import java.util.List;

public class Cp1448 {
    public static void main(String args[]) {
    }

    int result = 0;

    // Main idea: tree, preorder.
    // Time: O(n).
    // Space: O(log(n)).
    public int goodNodes(TreeNode root) {
        if (root == null) return result;
        helper(root, root.val);
        return result;
    }

    private void helper(TreeNode node, int maxVal) {
        if (node == null) return;
        if (node.val >= maxVal) {
            result++;
        }
        helper(node.left, Math.max(maxVal, node.val));
        helper(node.right, Math.max(maxVal, node.val));
    }
}
