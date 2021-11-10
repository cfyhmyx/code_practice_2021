// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

public class Cp1039 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, memorization.
    // Time: O(n^3).
    // Space: O(n^2).
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        return helper(A, 0, A.length - 1, dp);
    }

    private int helper(int[] A, int i, int j, int[][] dp) {
        int res = Integer.MAX_VALUE;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (j - i < 2) {
            return 0;
        }
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, A[i] * A[k] * A[j] + helper(A, i, k, dp) + helper(A, k, j, dp));
        }
        return dp[i][j] = res;
    }
}
