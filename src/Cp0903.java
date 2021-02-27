// https://leetcode.com/problems/valid-permutations-for-di-sequence/

import java.util.Arrays;

public class Cp0903 {
    public static void main(String args[]) {
        Cp0903 cp = new Cp0903();
        int result = cp.numPermsDISequence("DIDIDI");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^3), can be optimized to O(n^2).
    // Space: O(n^2).
    public int numPermsDISequence(String S) {
        int n = S.length(), M = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (S.charAt(i - 1) == 'D') {
                    for (int k = j; k < i; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= M;
                    }
                } else {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= M;
                    }
                }
            }
        }
        int result = 0;
        for (int j = 0; j <= n; j++) {
            result += dp[n][j];
            result %= M;
        }
        return result;
    }
}
