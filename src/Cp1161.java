// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class Cp1161 {
    public static void main(String args[]) {
    }

    // Main idea: bfs.
    // Time: O(n).
    // Space: O(n).
    public int maxLevelSum(TreeNode root) {
        int result = root.val;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLevel = 0;
        while (!queue.isEmpty()) {
            curLevel++;
            int s = queue.size();
            int levelSum = 0;
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (levelSum > result) {
                result = levelSum;
                level = curLevel;
            }
        }
        return level;
    }
}
