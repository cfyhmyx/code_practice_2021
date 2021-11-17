// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class Cp1008 {
    public static void main(String args[]) {
        Cp1008 cp = new Cp1008();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = cp.bstFromPreorder(preorder);
        System.out.print(root.val);
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(n).
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        helper(preorder, 0, root, 1001);
        return root;
    }

    private int helper(int[] preorder, int index, TreeNode cur, int limit) {
        if (index + 1 < preorder.length && preorder[index + 1] < cur.val) {
            TreeNode left = new TreeNode(preorder[index + 1]);
            cur.left = left;
            index = helper(preorder, index + 1, left, cur.val);
        }
        if (index + 1 < preorder.length && preorder[index + 1] > cur.val && preorder[index + 1] < limit) {
            TreeNode right = new TreeNode(preorder[index + 1]);
            cur.right = right;
            index = helper(preorder, index + 1, right, limit);
        }
        return index;
    }
}
