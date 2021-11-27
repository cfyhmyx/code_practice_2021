// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class Cp0958 {
    public static void main(String args[]) {
    }

    // Main idea: queue.
    // Time: O(n).
    // Space: O(n).
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (true) {
            TreeNode node = bfs.poll();
            if (node.left == null) {
                if (node.right != null)
                    return false;
                break;
            }
            bfs.offer(node.left);
            if (node.right == null) break;
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node.left != null || node.right != null)
                return false;
        }
        return true;
    }
}
