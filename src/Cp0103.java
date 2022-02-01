// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.ArrayList;
import java.util.List;

public class Cp0103 {
    public static void main(String args[]) {
    }

    // Main idea: dfs
    // Time: O(n).
    // Space: O(n).
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<List<Integer>> result, int height) {
        if (root == null) return;
        if (height >= result.size()) {
            result.add(new ArrayList<>());
        }
        if (height % 2 == 0) {
            result.get(height).add(root.val);
        } else {
            result.get(height).add(0, root.val);
        }
        helper(root.left, result, height + 1);
        helper(root.right, result, height + 1);
    }
}
