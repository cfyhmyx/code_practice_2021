// https://leetcode.com/problems/maximum-students-taking-exam/

import java.util.Arrays;

public class Cp1349 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(m * 2^n * 2^n).
    // Space: O(m * 2^n).
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] validRows = new int[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                validRows[i] = (validRows[i] << 1) + (seats[i][j] == '.' ? 1 : 0);
        int stateSize = 1 << n; // There are 2^n states for n columns in binary format
        int[][] dp = new int[m][stateSize];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < stateSize; j++) {
                // (j & valid) == j: check if j is a subset of valid
                // !(j & (j >> 1)): check if there is no adjacent students in the row
                if (((j & validRows[i]) == j) && ((j & (j >> 1)) == 0)) {
                    if (i == 0) {
                        dp[i][j] = Integer.bitCount(j);
                    } else {
                        for (int k = 0; k < stateSize; k++) {
                            // !(j & (k >> 1)): no students in the upper left positions
                            // !((j >> 1) & k): no students in the upper right positions
                            // dp[i-1][k] != -1: the previous state is valid
                            if ((j & (k >> 1)) == 0 && ((j >> 1) & k) == 0 && dp[i - 1][k] != -1) {
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Integer.bitCount(j));
                            }
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
