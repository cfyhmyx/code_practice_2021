// https://leetcode.com/problems/path-with-minimum-effort/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cp1631 {
    public static void main(String args[]) {
    }

    // Main idea: Dijkstra.
    // Time: O(m*n*log(m*n))
    // Space: O(m*n).
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // The minimum effort from [0, 0] to [i, j].
        int[][] efforts = new int[m][n];
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[3]);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0];
            int row = cur[1];
            int col = cur[2];
            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;
                if (efforts[nextRow][nextCol] > Math.max(effort, Math.abs(heights[nextRow][nextCol] - heights[row][col]))) {
                    efforts[nextRow][nextCol] = Math.max(effort, Math.abs(heights[nextRow][nextCol] - heights[row][col]));
                    pq.offer(new int[]{efforts[nextRow][nextCol], nextRow, nextCol});
                }
            }
        }
        return efforts[m - 1][n - 1];
    }

    // Main idea: bellman-ford, shortest path faster algorithm.
    // Time: O(m*n*m*n)
    // Space: O(m*n).
    /*public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // The minimum effort from [0, 0] to [i, j].
        int[][] efforts = new int[m][n];
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[3]);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int effort = cur[0];
            int row = cur[1];
            int col = cur[2];
            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;
                if (efforts[nextRow][nextCol] > Math.max(effort, Math.abs(heights[nextRow][nextCol] - heights[row][col]))) {
                    efforts[nextRow][nextCol] = Math.max(effort, Math.abs(heights[nextRow][nextCol] - heights[row][col]));
                    queue.offer(new int[]{efforts[nextRow][nextCol], nextRow, nextCol});
                }
            }
        }
        return efforts[m-1][n-1];
    }*/
}
