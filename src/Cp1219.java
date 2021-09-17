// https://leetcode.com/problems/path-with-maximum-gold/

public class Cp1219 {
    public static void main(String args[]) {
        Cp1219 cp = new Cp1219();
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int result = cp.getMaximumGold(grid);
        System.out.print(result);
    }

    // Main idea: dfs, backtracking.
    // Time: O(3^k).
    // Space: O(1).
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, helper(grid, i, j, m, n, dirs));
                }
            }
        }
        return result;
    }

    private int helper(int[][] grid, int row, int col, int m, int n, int[][] dirs) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }
        int oldVal = grid[row][col];
        grid[row][col] = 0;
        int temp = 0;
        for (int[] dir : dirs) {
            temp = Math.max(temp, helper(grid, row + dir[0], col + dir[1], m, n, dirs));
        }
        grid[row][col] = oldVal;
        return temp + grid[row][col];
    }
}
