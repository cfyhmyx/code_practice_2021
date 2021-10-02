// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

import java.util.LinkedList;
import java.util.Queue;

public class Cp1123 {
    public static void main(String args[]) {
    }

    private int deepest = 0;
    private TreeNode lca;

    // Main idea: tree, post order.
    // Time: O(n).
    // Space: O(n).
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) {
            return depth;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == deepest && right == deepest) {
            lca = node;
        }
        return Math.max(left, right);
    }

    /*public TreeNode lcaDeepestLeaves(TreeNode root) {
        int first = -1;
        int last = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    first = cur.val;
                }
                if (i == size - 1) {
                    last = cur.val;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return getLca(root, first, last);
    }

    private TreeNode getLca(TreeNode node, int left, int right) {
        if (node == null) return null;
        if (left == node.val || right == node.val) {
            return node;
        }
        TreeNode leftLca = getLca(node.left, left, right);
        TreeNode rightLca = getLca(node.right, left, right);
        if (leftLca != null && rightLca != null) {
            return node;
        } else if (leftLca != null) {
            return leftLca;
        } else {
            return rightLca;
        }
    }*/
}
