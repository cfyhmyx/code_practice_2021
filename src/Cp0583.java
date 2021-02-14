// https://leetcode.com/problems/delete-operation-for-two-strings/

import java.util.Arrays;

public class Cp0583 {
    public static void main(String args[]) {
        Cp0583 cp = new Cp0583();
        int result = cp.minDistance("sea", "eat");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n), can be optimized to O(min(m, n)).
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m - dp[m][n] + n - dp[m][n];
    }

    /* public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        String lcs = lcs(word1, word2);
        int result = 0;
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < lcs.length(); i++) {
            while (p1 < word1.length() && word1.charAt(p1) != lcs.charAt(i)) {
                result++;
                p1++;
            }
            while (p2 < word2.length() && word2.charAt(p2) != lcs.charAt(i)) {
                result++;
                p2++;
            }
            p1++;
            p2++;
        }
        result += m - p1 + n - p2;
        return result;
    }

    private String lcs(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + word1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }*/
}
