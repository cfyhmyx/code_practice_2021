// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

import java.util.ArrayList;
import java.util.List;

public class Cp0107 {
    public static void main(String args[]) {
    }

    // Main idea: dfs
    // Time: O(n).
    // Space: O(n).
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<List<Integer>> result, int height) {
        if(root == null) return;
        if(height >= result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size()-height-1).add(root.val);
        helper(root.left, result, height+1);
        helper(root.right, result, height+1);
    }
}
