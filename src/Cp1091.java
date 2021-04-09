// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.LinkedList;
import java.util.Queue;

public class Cp1091 {
    public static void main(String args[]) {
        Cp1091 cp = new Cp1091();
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int result = cp.shortestPathBinaryMatrix(grid);
        System.out.println(result);
    }

    // Main idea: bfs.
    // Time: O(n^2).
    // Space: O(1).
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0});
        }
        while (!queue.isEmpty()) {
            int s = queue.size();
            result++;
            for (int i = 0; i < s; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return result;
                }
                // visited.
                if (grid[cur[0]][cur[1]] != 0) continue;
                grid[cur[0]][cur[1]] = -1;
                for (int[] dir : dirs) {
                    int nextRow = cur[0] + dir[0];
                    int nextCol = cur[1] + dir[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != 0) {
                        continue;
                    }
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
        return -1;
    }
}
