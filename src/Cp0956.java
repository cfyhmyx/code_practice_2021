// https://leetcode.com/problems/tallest-billboard/

import java.util.Arrays;

public class Cp0956 {
    public static void main(String args[]) {
        Cp0956 cp = new Cp0956();
        int[] rods = {1, 2, 3, 6};
        int result = cp.tallestBillboard(rods);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(length * sum).
    // Space: O(length * sum).
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[][] dp = new int[rods.length + 1][sum + 1];
        for (int i = 0; i <= rods.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= rods.length; i++) {
            int h = rods[i - 1];
            for (int j = 0; j <= sum - j; j++) {
                if (dp[i - 1][j] < 0) continue;
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j + h] = Math.max(dp[i][j + h], dp[i - 1][j]);
                dp[i][Math.abs(j - h)] = Math.max(dp[i][Math.abs(j - h)], dp[i - 1][j] + Math.min(h, j));
            }
        }
        return dp[rods.length][0];
    }
}
