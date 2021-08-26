// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

import java.util.HashSet;
import java.util.Set;

public class Cp1261 {
    public static void main(String args[]) {
    }

    class FindElements {
        private Set<Integer> set;

        // Main idea: recursion.
        // Time: O(n).
        // Space: O(n).
        public FindElements(TreeNode root) {
            set = new HashSet<>();
            helper(root, 0);
        }

        private void helper(TreeNode node, int val) {
            if (node == null) return;
            node.val = val;
            set.add(val);
            helper(node.left, 2*val+1);
            helper(node.right, 2*val+2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
