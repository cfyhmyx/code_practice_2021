// https://leetcode.com/problems/house-robber/

import java.util.List;

public class Cp0198 {
    public static void main(String args[]) {
        Cp0198 cp = new Cp0198();
        int[] nums = {2, 7, 9, 3, 1};
        int result = cp.rob(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int notRob = 0;
        int rob = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = notRob;
            notRob = Math.max(notRob, rob);
            rob = temp + nums[i];
        }
        return Math.max(notRob, rob);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(n).
    /*public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }*/
}
