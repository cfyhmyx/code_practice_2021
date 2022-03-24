// https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class Cp0145 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n), recursion stack size.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
}
