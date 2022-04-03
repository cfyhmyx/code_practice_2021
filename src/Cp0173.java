// https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.Stack;

public class Cp0173 {
    public static void main(String args[]) {
    }

    public class BSTIterator {

        // Main idea: tree
        // Time: O(n).
        // Space: O(n).
        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode cur = stack.pop();
            pushAll(cur.right);
            return cur.val;
        }

        private void pushAll(TreeNode node) {
            for (; node != null; stack.push(node), node = node.left) ;
        }
    }
}
