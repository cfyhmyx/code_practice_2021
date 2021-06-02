// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.*;

public class Cp0987 {
    public static void main(String args[]) {
    }

    // Main idea: treemap, heap.
    // Time: O(n*log(n)).
    // Space: O(n).
    private Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    private int minX = 0, maxX = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minX; i <= maxX; i++) {
            List<Integer> level = new ArrayList<>();
            for (int col : map.get(i).keySet()) {
                while (!(map.get(i).get(col)).isEmpty()) {
                    level.add(map.get(i).get(col).poll());
                }
            }
            result.add(level);
        }
        return result;

    }

    private void helper(TreeNode node, int x, int y) {
        if (node == null) return;
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        if (map.get(x) == null) {
            map.put(x, new TreeMap<>());
        }
        if (map.get(x).get(y) == null) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).add(node.val);
        helper(node.left, x - 1, y + 1);
        helper(node.right, x + 1, y + 1);
    }
}
