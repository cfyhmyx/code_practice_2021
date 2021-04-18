// https://leetcode.com/problems/diameter-of-binary-tree/

public class Cp0543 {
    public static void main(String args[]) {
        Cp0543 cp = new Cp0543();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int result = cp.diameterOfBinaryTree(node1);
        System.out.println(result);
    }

    private int result = 0;

    // Main idea: tree, post-order.
    // Time: O(n).
    // Space: O(n).
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}
