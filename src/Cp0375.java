// https://leetcode.com/problems/guess-number-higher-or-lower-ii/

import java.util.Arrays;

public class Cp0375 {
    public static void main(String args[]) {
        Cp0375 cp = new Cp0375();
        int result = cp.getMoneyAmount(10);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^3).
    // Space: O(n^2).
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
