// https://leetcode.com/problems/the-maze-ii/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Cp0505 {
    public static void main(String args[]) {
        Cp0505 cp = new Cp0505();
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int result = cp.shortestDistance(maze, new int[]{0, 4}, new int[]{3, 2});
        System.out.println(result);
    }

    // Main idea: Dijkstra.
    // Time: O(m*n*log(m*n))
    // Space: O(m*n).
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = maze.length;
        int n = maze[0].length;
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
        }
        dis[start[0]][start[1]] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (dis[a[0]][a[1]] - dis[b[0]][b[1]]));
        q.offer(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int[] next = new int[2];
                int step = nextPos(maze, cur, next, dir);
                if (dis[next[0]][next[1]] > dis[cur[0]][cur[1]] + step) {
                    dis[next[0]][next[1]] = dis[cur[0]][cur[1]] + step;
                    if (next[0] == destination[0] && next[1] == destination[1]) return dis[next[0]][next[1]];
                    q.offer(next);
                }
            }
        }
        return -1;
    }

    int nextPos(int[][] maze, int[] cur, int[] next, int[] dir) {
        int m = maze.length;
        int n = maze[0].length;
        int row = cur[0];
        int col = cur[1];
        int step = 0;
        while (row + dir[0] >= 0 && row + dir[0] < m &&
                col + dir[1] >= 0 && col + dir[1] < n &&
                maze[row + dir[0]][col + dir[1]] != 1) {
            row += dir[0];
            col += dir[1];
            step++;
        }
        next[0] = row;
        next[1] = col;
        return step;
    }
}
