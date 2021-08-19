// https://leetcode.com/problems/tree-diameter/

import java.util.ArrayList;
import java.util.List;

public class Cp1245 {
    public static void main(String args[]) {
    }

    private int diameter = 0;

    // Main idea: graph, backtracking.
    // Time: O(E).
    // Space: O(E).
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        helper(0, -1, graph);
        return diameter;
    }

    private int helper(int root, int parent, List<Integer>[] graph) {
        int maxDepth = 0;
        int secondMaxDepth = 0;
        for (int child : graph[root]) {
            if (child == parent) continue;
            int curDepth = helper(child, root, graph);
            if (curDepth > maxDepth) {
                secondMaxDepth = maxDepth;
                maxDepth = curDepth;
            } else if (curDepth > secondMaxDepth) {
                secondMaxDepth = curDepth;
            }
        }
        int longestPathThroughRoot = maxDepth + secondMaxDepth + 1;
        diameter = Math.max(diameter, longestPathThroughRoot - 1);
        return maxDepth + 1;
    }
}
