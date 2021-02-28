// https://leetcode.com/problems/coin-change/

import java.util.Arrays;

public class Cp0322 {
    public static void main(String args[]) {
        Cp0322 cp = new Cp0322();
        int[] nums = {195, 265, 404, 396};
        int result = cp.coinChange(nums, 3239);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n).
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] >= Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}
