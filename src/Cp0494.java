// https://leetcode.com/problems/target-sum/

import java.util.HashMap;
import java.util.Map;

public class Cp0494 {
    public static void main(String args[]) {
        Cp0494 cp = new Cp0494();
        int[] nums = {1, 1, 1, 1, 1};
        int result = cp.findTargetSumWays(nums, 3);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n^2).
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> dp = new HashMap();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap();
            for (int tempSum : dp.keySet()) {
                int key1 = tempSum + num;
                dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
                int key2 = tempSum - num;
                dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
            }
            dp = dp2;
        }
        return dp.getOrDefault(S, 0);
    }
}
