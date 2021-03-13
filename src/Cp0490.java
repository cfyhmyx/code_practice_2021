// https://leetcode.com/problems/the-maze/

import java.util.LinkedList;
import java.util.Queue;

public class Cp0490 {
    public static void main(String args[]) {
        Cp0490 cp = new Cp0490();
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        boolean result = cp.hasPath(maze, new int[]{0, 4}, new int[]{4, 4});
        System.out.println(result);
    }

    // Main idea: bfs.
    // Time: O(m*n)
    // Space: O(m*n).
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int[] next = nextPos(maze, cur, dir);
                if (next[0] == destination[0] && next[1] == destination[1]) return true;
                if (visited[next[0]][next[1]]) continue;
                visited[next[0]][next[1]] = true;
                q.offer(next);
            }
        }
        return false;
    }

    int[] nextPos(int[][] maze, int[] cur, int[] dir) {
        int m = maze.length;
        int n = maze[0].length;
        int row = cur[0];
        int col = cur[1];
        while (row + dir[0] >= 0 && row + dir[0] < m &&
                col + dir[1] >= 0 && col + dir[1] < n &&
                maze[row + dir[0]][col + dir[1]] != 1) {
            row += dir[0];
            col += dir[1];
        }
        return new int[]{row, col};
    }
}
