// https://leetcode.com/problems/flower-planting-with-no-adjacent/

import java.util.ArrayList;
import java.util.List;

public class Cp1042 {
    public static void main(String args[]) {
        Cp1042 cp = new Cp1042();
        int[][] paths = {};
        int[] result = cp.gardenNoAdj(1, paths);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(V+E).
    // Space: O(V+E).
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new List[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        buildGraph(graph, paths);
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            helper(graph, i, colors);
        }
        return colors;
    }

    private boolean helper(List<Integer>[] graph, int index, int[] colors) {
        if (colors[index] != 0) return true;
        boolean[] usedColor = new boolean[5];
        int colored = 0;
        for (int ne : graph[index]) {
            if (colors[ne] != 0) {
                usedColor[colors[ne]] = true;
                colored++;
            }
        }
        for (int i = 1; i <= 4; i++) {
            if (usedColor[i]) continue;
            colors[index] = i;
            if (colored == graph[index].size()) return true;
            for (int ne : graph[index]) {
                if (helper(graph, ne, colors)) {
                    return true;
                }
            }
        }
        colors[index] = 0;
        return false;
    }

    private void buildGraph(List<Integer>[] graph, int[][] paths) {
        for (int[] path : paths) {
            graph[path[0] - 1].add(path[1] - 1);
            graph[path[1] - 1].add(path[0] - 1);
        }
    }
}
