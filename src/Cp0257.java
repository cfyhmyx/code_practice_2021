// https://leetcode.com/problems/binary-tree-paths/

import java.util.ArrayList;
import java.util.List;

public class Cp0257 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(log(n)).
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        if (root == null) return lst;
        dfs(root, lst, new StringBuilder());
        return lst;
    }

    public void dfs(TreeNode node, List<String> lst, StringBuilder sb) {
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            lst.add(sb.toString());
            return;
        }
        sb.append("->");
        if (node.left != null) dfs(node.left, lst, new StringBuilder(sb));
        if (node.right != null) dfs(node.right, lst, new StringBuilder(sb));
    }
}
