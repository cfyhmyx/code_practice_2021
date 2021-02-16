// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

import java.util.Arrays;

public class Cp1335 {
    public static void main(String args[]) {
        Cp1335 cp = new Cp1335();
        int[] jobDifficulty = {11, 111, 22, 222, 33, 333, 44, 444};
        int result = cp.minDifficulty(jobDifficulty, 6);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * n * d).
    // Space: O(n * d).
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] dp = new int[n + 1][d + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= Math.min(i, d); k++) {
                int maxDif = 0;
                for (int j = i; j >= k; j--) {
                    maxDif = Math.max(maxDif, jobDifficulty[j - 1]);
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - 1] + maxDif);
                }
            }
        }
        return dp[n][d];
    }
}
