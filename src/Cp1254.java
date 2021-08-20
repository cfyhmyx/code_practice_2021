// https://leetcode.com/problems/number-of-closed-islands/

public class Cp1254 {
    public static void main(String args[]) {
    }

    // Main idea: backtracking.
    // Time: O(m*n).
    // Space: O(m*n).
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (helper(grid, i, j, m, n)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean helper(int[][] grid, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n) return false;
        if (grid[row][col] != 0) return true;
        grid[row][col] = 2;
        boolean up = helper(grid, row + 1, col, m, n);
        boolean down = helper(grid, row - 1, col, m, n);
        boolean right = helper(grid, row, col + 1, m, n);
        boolean left = helper(grid, row, col - 1, m, n);
        return up && down && right && left;
    }
}
