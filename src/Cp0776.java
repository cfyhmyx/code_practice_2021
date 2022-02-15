// https://leetcode.com/problems/split-bst/

public class Cp0776 {
    public static void main(String[] args) {
    }

    // Main idea: tree, recursion
    // Time: O(n).
    // Space: O(n).
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root==null) return new TreeNode[]{null, null};
        TreeNode[] split;
        if(root.val<= target) {
            split = splitBST(root.right, target);
            root.right = split[0];
            split[0] = root;
        } else {
            split = splitBST(root.left, target);
            root.left = split[1];
            split[1] = root;
        }
        return split;
    }
}
