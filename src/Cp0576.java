// https://leetcode.com/problems/out-of-boundary-paths/

import java.util.HashMap;
import java.util.Map;

public class Cp0576 {
    public static void main(String args[]) {
        Cp0576 cp = new Cp0576();
        int result = cp.findPaths(2,3,8,1, 0);
        System.out.print(result);
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int mod = (int)1e9 + 7;

    // Main idea: dfs, memorization.
    // Time: O(m*n*maxMove).
    // Space: O(m*n*maxMove).
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return helper(m, n, startRow, startColumn, new HashMap<>(), maxMove);
    }

    private int helper(int m, int n, int row, int col, Map<String, Integer> map, int maxMove) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        String key = "" + row + '&' + col + '&' + maxMove;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (maxMove == 0) {
            return 0;
        }
        int result = 0;
        for (int[] dir : dirs) {
            result += helper(m, n, row + dir[0], col + dir[1], map, maxMove - 1);
            result %= mod;
        }
        map.put(key, result);
        return result;
    }

    /*public int findPaths(int m, int n, int N, int i, int j) {
        // m * n grid
        long[][][] memo = new long[m][n][N+1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int kk = 0; kk < N+1; kk++) {
                    memo[ii][jj][kk] = -1;
                }
            }
        }
        return (int) (dfs(m, n, N, i, j, memo) % mod);
    }

    public long dfs(int m, int n, int N, int i, int j, long[][][] memo) {
        //check if out of boundary, if out could not move back
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) return 0;
        if (memo[i][j][N] != -1) return memo[i][j][N];
        memo[i][j][N] = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            memo[i][j][N] = (memo[i][j][N] + dfs(m, n, N - 1, x, y, memo) % mod) % mod;
        }
        return memo[i][j][N];
    }*/
}
