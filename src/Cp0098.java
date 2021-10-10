// https://leetcode.com/problems/validate-binary-search-tree/

public class Cp0098 {
    public static void main(String args[]) {
    }

    // Main idea: tree, recursion.
    // Time: O(n).
    // Space: O(n).
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isValidWithBound(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidWithBound(TreeNode root, double low, double high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return isValidWithBound(root.left, low, root.val) && isValidWithBound(root.right, root.val, high);
    }
}
