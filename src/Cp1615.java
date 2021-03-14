// https://leetcode.com/problems/maximal-network-rank/

public class Cp1615 {
    public static void main(String args[]) {
        Cp1615 cp = new Cp1615();
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
        int result = cp.maximalNetworkRank(8, roads);
        System.out.println(result);
    }

    // Main idea: graph.
    // Time: O(n*n)
    // Space: O(n*n).
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        int[][] adj = new int[n][n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            adj[road[0]][road[1]] = 1;
            adj[road[1]][road[0]] = 1;
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int rank = degree[i] + degree[j];
                if (adj[i][j] == 1 || adj[j][i] == 1) {
                    rank--;
                }
                result = Math.max(result, rank);
            }
        }
        return result;
    }
}
