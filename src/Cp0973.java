// https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.PriorityQueue;

public class Cp0973 {
    public static void main(String args[]) {
        Cp0973 cp = new Cp0973();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] result = cp.kClosest(points, 2);
        for (int i=0; i<result.length; i++) {
            System.out.println("[" + result[i][0] + " , " + result[i][1] + "]");
        }
    }

    // Main idea: heap.
    // Time: O(n*log(k)).
    // Space: O(k).
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
        for (int[] point : points) {
            pq.add(new int[]{point[0], point[1], point[0] * point[0] + point[1] * point[1]});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            result[index][0] = cur[0];
            result[index][1] = cur[1];
            index++;
        }
        return result;
    }
}
