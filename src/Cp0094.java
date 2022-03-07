// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class Cp0094 {
    public static void main(String args[]) {
    }

    // Main idea: recursion
    // Time: O(n).
    // Space: O(n).
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}
