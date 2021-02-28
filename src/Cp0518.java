// https://leetcode.com/problems/coin-change-2/

public class Cp0518 {
    public static void main(String args[]) {
        Cp0518 cp = new Cp0518();
        int[] nums = {1, 2, 5};
        int result = cp.change(5, nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n).
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
