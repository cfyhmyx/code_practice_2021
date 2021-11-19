// https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class Cp0994 {
    public static void main(String args[]) {
    }

    // Main idea: bfs.
    // Time: O(m*n).
    // Space: O(m*n).
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (count == 0) return 0;
        int min = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                count--;
                if (count == 0) return min;
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
                        continue;
                    }
                    grid[row][col] = 2;
                    queue.add(new int[]{row, col});
                }
            }
            min++;
        }
        return -1;
    }
}
