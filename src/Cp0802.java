// https://leetcode.com/problems/find-eventual-safe-states/

import java.util.*;

public class Cp0802 {
    public static void main(String args[]) {
        Cp0802 cp = new Cp0802();
        int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        List<Integer> result = cp.eventualSafeNodes(graph);
        System.out.println(result);
    }

    // Main idea: dfs, color.
    // Time: O(V+E).
    // Space: O(V+E).
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> terminal = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if(helper(graph, terminal, visited, i)) {
                result.add(i);
            }
        }
        return result;
    }

    // Better: int[] color, 0: not visited, 1: visited and safe, 2: visited and unsafe
    private boolean helper(int[][] graph, Set<Integer> terminal, Set<Integer> visited, int index) {
        if (terminal.contains(index)) return true;
        if (visited.contains(index)) return false;
        visited.add(index);
        for (int next : graph[index]) {
            if (!helper(graph, terminal, visited, next)) {
                return false;
            }
        }
        terminal.add(index);
        return true;
    }
}
