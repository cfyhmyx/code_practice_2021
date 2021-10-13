public class Cp0099 {
    public static void main(String args[]) {
    }

    // Main idea: tree, recursion.
    // Time: O(n), n is the number of tree node.
    // Space: O(n).
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        TreeNode[] candidates = new TreeNode[2];
        helper(root, candidates);
        int temp = candidates[0].val;
        candidates[0].val = candidates[1].val;
        candidates[1].val = temp;
    }

    private void helper(TreeNode node, TreeNode[] candidates) {
        if (node == null) return;
        helper(node.left, candidates);
        if (prev != null && node.val <= prev.val) {
            if (candidates[0] == null) {
                candidates[0] = prev;
            }
            candidates[1] = node;
        }
        prev = node;
        helper(node.right, candidates);
    }
}
