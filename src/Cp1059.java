// https://leetcode.com/problems/all-paths-from-source-lead-to-destination/

import java.util.ArrayList;
import java.util.List;

public class Cp1059 {
    public static void main(String args[]) {
        Cp1059 cp = new Cp1059();
        int[][] edges = {{0, 1}, {0, 2}};
        boolean result = cp.leadsToDestination(3, edges, 0, 2);
        System.out.print(result);
    }

    // Main idea: graph.
    // Time: O(V+E).
    // Space: O(V+E).
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        if (graph[destination].size() != 0) return false;
        boolean[] reach = new boolean[n];
        boolean[] visited = new boolean[n];
        return helper(graph, source, destination, reach, visited);
    }

    private boolean helper(List<Integer>[] graph, int cur, int destination, boolean[] reach, boolean[] visited) {
        if (cur == destination || reach[cur]) {
            return true;
        }
        if (visited[cur] || graph[cur].size() == 0) {
            return false;
        }
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (!helper(graph, next, destination, reach, visited)) {
                return false;
            }
        }
        visited[cur] = false;
        reach[cur] = true;
        return true;
    }
}
