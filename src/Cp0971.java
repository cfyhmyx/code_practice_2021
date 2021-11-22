// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

import java.util.*;

public class Cp0971 {
    public static void main(String args[]) {
    }

    private List<Integer> res = new ArrayList<>();

    private int i = 0;

    // Main idea: tree, recursion.
    // Time: O(n).
    // Space: O(n).
    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        return dfs(root, v) ? res : Arrays.asList(-1);
    }

    public Boolean dfs(TreeNode node, int[] v) {
        if (node == null) return true;
        if (node.val != v[i++]) return false;
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
        }
        return dfs(node.left, v) && dfs(node.right, v);
    }
}
