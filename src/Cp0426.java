// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

import java.util.Stack;

public class Cp0426 {
    public static void main(String args[]) {
    }

    // Main idea: stack, inorder.
    // Time: O(n).
    // Space: O(n).
    public TreeNode treeToDoublyList(TreeNode root) {
        TreeNode head = new TreeNode();
        TreeNode pre = head;
        TreeNode cur = root;
        Stack<TreeNode> stack =  new Stack<>();
        while (true) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else if (!stack.empty()) {
                cur = stack.pop();
                pre.right = cur;
                cur.left = pre;
                pre = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        pre.right = head.right;
        head.right.left =pre;
        return head.right;
    }

    // Inorder, recursion.
    /*TreeNode prev = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode dummy = new TreeNode();
        prev = dummy;
        helper(root);
        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper (TreeNode cur) {
        if (cur == null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
    }*/
}
