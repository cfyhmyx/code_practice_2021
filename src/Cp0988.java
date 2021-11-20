// https://leetcode.com/problems/smallest-string-starting-from-leaf/

public class Cp0988 {
    public static void main(String args[]) {
    }

    private String result = "";

    // Main idea: dfs, backtracking.
    // Time: O(n^2).
    // Space: O(n).
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return result;
    }

    private void helper(TreeNode cur, String path) {
        path = (char)('a' + cur.val) + path;
        if (cur.left == null && cur.right == null) {
            if (result.isEmpty() || path.compareTo(result) < 0) {
                result = path;
            }
        }
        if (cur.left != null) {
            helper(cur.left, path);
        }
        if (cur.right != null) {
            helper(cur.right, path);
        }
    }
}
