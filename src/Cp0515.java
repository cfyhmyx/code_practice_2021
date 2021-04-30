// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp0515 {
    public static void main(String args[]) {
    }

    // Main idea: bfs.
    // Time: O(n).
    // Space: O(n).
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            int local = Integer.MIN_VALUE;
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                local = Math.max(local, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(local);
        }
        return result;
    }
}
