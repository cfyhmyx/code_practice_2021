// https://leetcode.com/problems/path-with-maximum-probability/

import java.util.*;

public class Cp1514 {
    public static void main(String args[]) {
    }

    // Main idea: Dijkstra.
    // Time: O(n+E*log(m*n))
    // Space: O(n+E).
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            adj.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            adj.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] prob = new double[n];
        prob[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -prob[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) {
                return prob[end];
            }
            for (int[] a : adj.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (prob[cur] * succProb[index] > prob[neighbor]) {
                    prob[neighbor] = prob[cur] * succProb[index];
                    pq.offer(neighbor);
                }
            }
        }
        return 0d;
    }
}
