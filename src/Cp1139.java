// https://leetcode.com/problems/largest-1-bordered-square/

public class Cp1139 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n^3).
    // Space: O(n^2).
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int[][] hor = new int[m][n];
        int[][] ver = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hor[i][j] = i == 0 ? 1 : hor[i - 1][j] + 1;
                    ver[i][j] = j == 0 ? 1 : ver[i][j - 1] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int small = Math.min(hor[i][j], ver[i][j]);
                while (small > max) {
                    if (hor[i][j - small + 1] >= small && ver[i - small + 1][j] >= small) {
                        max = small;
                    }
                    small--;
                }
            }
        }
        return max * max;
    }
}
