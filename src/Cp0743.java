// https://leetcode.com/problems/network-delay-time/

import java.util.*;

public class Cp0743 {
    public static void main(String args[]) {
        Cp0743 cp = new Cp0743();
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        int result = cp.networkDelayTime(times, 3, 1);
        System.out.println(result);
    }

    // Main idea: Dijkstra.
    // Time: O(n+E*log(n))
    // Space: O(n+E).
    public int networkDelayTime(int[][] times, int n, int k) {
        if (n == 1) return 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], l -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (dis[a] - dis[b]));
        pq.add(k);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int[] edge : adj.getOrDefault(cur, Collections.emptyList())) {
                if (edge[1] + dis[cur] < dis[edge[0]]) {
                    dis[edge[0]] = edge[1] + dis[cur];
                    pq.add(edge[0]);
                }
            }
        }
        int result = -1;
        for (int i=1; i<=n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dis[i]);
        }
        return result;
    }
}
