// https://leetcode.com/problems/shortest-bridge/

import java.util.LinkedList;
import java.util.Queue;

public class Cp0934 {
    public static void main(String args[]) {
        Cp0934 cp = new Cp0934();
        int[][] A = {{1,1,1,1,1}, {0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,1,1,1}};
        int result = cp.shortestBridge(A);
        System.out.println(result);
    }

    // Main idea: dfs, bfs.
    // Time: O(m * n).
    // Space: O(m * n).
    public int shortestBridge(int[][] A) {
        int[][] dirs = {{0, -1}, {-1, -0}, {0, 1}, {1, 0}};
        int m = A.length;
        int n = A[0].length;
        boolean findIsland = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    findIsland(A, i, j, m, n, dirs, q);
                    findIsland = true;
                    break;
                }
            }
            if (findIsland) break;
        }
        int result = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i=0; i<s; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || A[row][col] == 2) continue;
                    if (A[row][col] == 1) return result;
                    if (A[row][col] == 0) {
                        A[row][col] = 2;
                        q.add(new int[]{row, col});
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private void findIsland(int[][] A, int row, int col, int m, int n, int[][] dirs, Queue<int[]> q) {
        if (row < 0 || row >= m || col < 0 || col >= n || A[row][col] != 1) return;
        A[row][col] = 2;
        q.add(new int[]{row, col});
        for (int[] dir : dirs) {
            findIsland(A, row + dir[0], col + dir[1], m, n, dirs, q);
        }
    }
}
