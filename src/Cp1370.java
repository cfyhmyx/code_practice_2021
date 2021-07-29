// https://leetcode.com/problems/shortest-path-to-get-food/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Cp1370 {
    public static void main(String args[]) {
    }

    // Main idea: bfs.
    // Time: init: O(n^2).
    // Space: O(n^2).
    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new int[]{i, j});
                    set.add(i * n + j);
                    break;
                }
            }
            if (!queue.isEmpty()) break;
        }
        int step = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 'X' || set.contains(row * n + col)) {
                        continue;
                    }
                    if (grid[row][col] == '#') {
                        return step;
                    }
                    set.add(row * n + col);
                    queue.add(new int[]{row, col});
                }
            }
        }
        return -1;
    }
}
