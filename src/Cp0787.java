// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.*;

public class Cp0787 {
    public static void main(String args[]) {
        Cp0787 cp = new Cp0787();
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int result = cp.findCheapestPrice(5, flights, 0, 2, 2);
        System.out.println(result);
    }

    // Main idea: bellman-ford, shortest path faster algorithm.
    // Time: O(m * k), m is the number of edges.
    // Space: O(m + n).
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int a = flights[i][0];
            int b = flights[i][1];
            map.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, flights[i][2]});
        }
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == src) {
                prices[i] = 0;
            } else {
                prices[i] = Integer.MAX_VALUE / 2;
            }
        }
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(src);
        while (!pq.isEmpty() && K >= 0) {
            int size = pq.size();
            int[] prices2 = prices.clone();
            for (int i = 0; i < size; i++) {
                int cur = pq.poll();
                for (int[] edge : map.getOrDefault(cur, Collections.emptyList())) {
                    if (prices[cur] + edge[1] < prices2[edge[0]]) {
                        prices2[edge[0]] = prices[cur] + edge[1];
                        pq.offer(edge[0]);
                    }
                }
            }
            K--;
            prices = prices2.clone();
        }
        return prices[dst] == Integer.MAX_VALUE / 2 ? -1 : prices[dst];
    }
}
