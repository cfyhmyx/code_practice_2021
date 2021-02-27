// https://leetcode.com/problems/minimum-cost-for-tickets/

import java.util.Arrays;

public class Cp0983 {
    public static void main(String args[]) {
        Cp0983 cp = new Cp0983();
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        int result = cp.mincostTickets(days, costs);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(n).
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        int[] time = {1, 7, 30};
        int index = 0;
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < costs.length; j++) {
                if (i == days[index]) {
                    dp[i] = Math.min(dp[i], i - time[j] >= 0 ? dp[i - time[j]] + costs[j] : costs[j]);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            if (i == days[index]) {
                index++;
            }
        }
        return dp[n];
    }

}
