// https://leetcode.com/problems/partition-equal-subset-sum/

public class Cp0416 {
    public static void main(String args[]) {
        Cp0416 cp = new Cp0416();
        int[] nums = {2, 2, 1, 1};
        boolean result = cp.canPartition(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * sum).
    // Space: O(sum).
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                dp[s] |= dp[s - num];
            }
        }
        return dp[target];
    }
}
