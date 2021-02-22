// https://leetcode.com/problems/last-stone-weight-ii/

import java.util.*;

public class Cp1049 {
    public static void main(String args[]) {
        Cp1049 cp = new Cp1049();
        int[] nums = {100, 7, 20, 30};
        int result = cp.lastStoneWeightII(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * sum).
    // Space: O(n * sum).
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, sum = 0;
        for (int s : stones) sum += s;
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[n][sum / 2];
    }

    /*public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(stones[0]);
        set.add(stones[0] * -1);
        for (int i = 1; i < stones.length; i++) {
            Set<Integer> tempSet = new HashSet<>();
            for (int temp : set) {
                tempSet.add(stones[i] + temp);
                tempSet.add(stones[i] - temp);
            }
            set = tempSet;
        }
        int result = Integer.MAX_VALUE;
        for (int sum : set) {
            result = Math.min(result, Math.abs(sum));
        }
        return result;
    }*/
}
