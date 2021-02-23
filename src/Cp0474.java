// https://leetcode.com/problems/ones-and-zeroes/

public class Cp0474 {
    public static void main(String args[]) {
        Cp0474 cp = new Cp0474();
        String[] nums = {"10", "0", "1"};
        int result = cp.findMaxForm(nums, 1, 1);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(length * m * n).
    // Space: O(length * m * n).
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int num1 = 0, num0 = 0;
            for (char ch : strs[i - 1].toCharArray()) {
                if (ch == '0') {
                    num0++;
                } else {
                    num1++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= num0 && k >= num1) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - num0][k - num1] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
