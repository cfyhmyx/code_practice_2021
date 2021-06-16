// https://leetcode.com/problems/path-sum-iii/

import java.util.HashMap;
import java.util.Map;

public class Cp0437 {
    public static void main(String args[]) {
    }

    private int result = 0;

    // Main idea: map.
    // Time: O(n).
    // Space: O(n).
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, 0, targetSum, map);
        return result;
    }

    private void helper(TreeNode node, int curSum, int targetSum, Map<Integer, Integer> map) {
        if (node == null) return;
        curSum += node.val;
        result += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        helper(node.left, curSum, targetSum, map);
        helper(node.right, curSum, targetSum, map);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }
}
