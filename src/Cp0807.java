// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

public class Cp0807 {
    public static void main(String args[]) {
        Cp0807 cp = new Cp0807();
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int result = cp.maxIncreaseKeepingSkyline(grid);
        System.out.println(result);
    }

    // Main idea: array.
    // Time: O(n^2).
    // Space: O(n).
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += Math.max(0, Math.min(rowMax[i], colMax[j]) - grid[i][j]);
            }
        }
        return result;
    }
}
