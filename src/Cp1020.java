// https://leetcode.com/problems/number-of-enclaves/

public class Cp1020 {
    public static void main(String args[]) {
        Cp1020 cp = new Cp1020();
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int result = cp.numEnclaves(grid);
        System.out.print(result);
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Main idea: dfs.
    // Time: O(m*n).
    // Space: O(m*n).
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            helper(grid, m, n, i, 0);
            helper(grid, m, n, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            helper(grid, m, n, 0, j);
            helper(grid, m, n, m - 1, j);
        }
        int result = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                result += grid[i][j];
            }
        }
        return result;
    }

    private void helper(int[][] grid, int m, int n, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        for (int[] dir : dirs) {
            helper(grid, m, n, row + dir[0], col + dir[1]);
        }
    }
}
