// https://leetcode.com/problems/delete-nodes-and-return-forest/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cp1110 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(n).
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> del = new HashSet<>();
        for (int td : to_delete) {
            del.add(td);
        }
        helper(root, result, del, true);
        return result;
    }

    private void helper(TreeNode cur, List<TreeNode> result, Set<Integer> del, boolean first) {
        if (cur == null) return;
        TreeNode left = cur.left;
        TreeNode right = cur.right;
        if (del.contains(cur.val)) {
            cur.left = null;
            cur.right = null;
            helper(left, result, del, true);
            helper(right, result, del, true);
        } else {
            if (first) {
                result.add(cur);
            }
            if (left != null && del.contains(left.val)) {
                cur.left = null;
            }
            if (right != null && del.contains(right.val)) {
                cur.right = null;
            }
            helper(left, result, del, false);
            helper(right, result, del, false);
        }
    }
}
