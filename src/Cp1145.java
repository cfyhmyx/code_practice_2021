// https://leetcode.com/problems/binary-tree-coloring-game/

public class Cp1145 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(n).
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode find = findNode(root, x);
        int left = getChildrenNum(find.left);
        int right = getChildrenNum(find.right);
        int up = n - left - right - 1;
        if (left > right + up + 1 || right > left + up + 1 || up > left + right + 1) return true;
        return false;
    }

    private TreeNode findNode(TreeNode cur, int x) {
        if (cur == null) return null;
        if (cur.val == x) return cur;
        TreeNode left = findNode(cur.left, x);
        if (left != null) return left;
        return findNode(cur.right, x);
    }

    private int getChildrenNum(TreeNode cur) {
        if (cur == null) return 0;
        return 1 + getChildrenNum(cur.left) + getChildrenNum(cur.right);
    }
}
