// https://leetcode.com/problems/score-after-flipping-matrix/

public class Cp0861 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(m*n).
    // Space: O(1).
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = (1 << (n - 1)) * m;
        for (int j = 1; j < n; j++) {
            int cur = 0;
            for (int i = 0; i < m; i++) cur += grid[i][j] == grid[i][0] ? 1 : 0;
            res += Math.max(cur, m - cur) * (1 << (n - j - 1));
        }
        return res;
    }
}
