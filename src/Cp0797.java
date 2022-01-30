// https://leetcode.com/problems/all-paths-from-source-to-target/

import java.util.ArrayList;
import java.util.List;


public class Cp0797 {
    public static void main(String args[]) {
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(graph, result, path, 0, graph.length - 1);
        return result;
    }

    // Main idea: dfs, backtracking.
    // Time: O(2^n).
    // Space: O(n).
    private void helper(int[][] graph, List<List<Integer>> result, List<Integer> path, int index, int target) {
        if (index == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[index].length; i++) {
            path.add(graph[index][i]);
            helper(graph, result, path, graph[index][i], target);
            path.remove(path.size() - 1);
        }
    }
}
