// https://leetcode.com/problems/minimum-path-sum/

public class Cp0064 {

    public static void main(String args[]) {
        Cp0064 cp = new Cp0064();
        int[][] nums = {{0,1}, {1,0}};
        int result = cp.minPathSum(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n).
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j=1; j<n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
