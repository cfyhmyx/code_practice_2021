// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

public class Cp0889 {
    public static void main(String args[]) {
    }

    private int preIndex = 0;
    private int posIndex = 0;

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(n).
    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        if (root.val != post[posIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        posIndex++;
        return root;
    }
}
