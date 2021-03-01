// https://leetcode.com/problems/redundant-connection/

import java.util.HashMap;
import java.util.Map;

public class Cp0684 {

    public static void main(String args[]) {
        Cp0684 cp = new Cp0684();
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result = cp.findRedundantConnection(edges);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private Map<Integer, Integer> rank = new HashMap<>();
    private Map<Integer, Integer> parentMap = new HashMap<>();

    // Main idea: union and find
    // Time: O(k*O(1)), k: edges, n: nodes
    // Space: O(n), n: nodes
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        for (int[] edge : edges) {
            if (!parentMap.containsKey(edge[0])) {
                parentMap.put(edge[0], edge[0]);
                rank.put(edge[0], 0);
            }
            if (!parentMap.containsKey(edge[1])) {
                parentMap.put(edge[1], edge[1]);
                rank.put(edge[1], 0);
            }
            if (!union(edge[0], edge[1])) {
                result[0] = edge[0];
                result[1] = edge[1];
            }
        }
        return result;
    }

    private boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        // They are already in the same group
        if (parent1 == parent2) {
            return false;
        }
        // Union by rank.
        if (rank.get(parent1) >= rank.get(parent2)) {
            parentMap.put(parent2, parent1);
            if (rank.get(parent1) == rank.get(parent2)) {
                rank.put(parent1, rank.get(parent1) + 1);
            }
        } else {
            parentMap.put(parent1, parent2);
        }
        return true;
    }

    private int find(int node) {
        if (node == parentMap.get(node)) {
            return node;
        }
        int parent = find(parentMap.get(node));
        // Path compression.
        parentMap.put(node, parent);
        return parent;
    }
}
