// https://leetcode.com/problems/path-with-maximum-minimum-value/

import java.util.PriorityQueue;

public class Cp1102 {
    public static void main(String args[]) {
    }

    // Main idea: Dijkstra.
    // Time: O(m*n*log(m*n)).
    // Space: O(m*n).
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.add(new int[]{0, 0, grid[0][0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            result = Math.min(result, cur[2]);
            if (cur[0] == m-1 && cur[1] == n-1) break;
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] < 0) continue;
                pq.add(new int[]{row, col, grid[row][col]});
                grid[row][col] = -1;
            }
        }
        return result;
    }
}
