// https://leetcode.com/problems/delete-tree-nodes/

import java.util.ArrayList;
import java.util.List;

public class Cp1273 {
    public static void main(String args[]) {
        Cp1273 cp = new Cp1273();
        int[] parent = {-1,0,0,1,2,2,2};
        int[] value = {1,-2,4,0,-2,-1,-1};
        int result = cp.deleteTreeNodes(7, parent, value);
        System.out.print(result);
    }

    // Main idea: dfs.
    // Time: O(n).
    // Space: O(n).
    public int deleteTreeNodes(int n, int[] parent, int[] value) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                graph.get(parent[i]).add(i);
            }
        }

        return dfs(graph, value, 0)[1];
    }
    private int[] dfs(List<List<Integer>> graph, int[] value, int root) {
        int totalSum = value[root];
        int totalNodes = 1;
        for (int child : graph.get(root)) {
            int[] temp = dfs(graph, value, child);
            totalSum += temp[0];
            totalNodes += temp[1];
        }
        if (totalSum == 0) totalNodes = 0;
        return new int[]{totalSum, totalNodes};
    }
}
