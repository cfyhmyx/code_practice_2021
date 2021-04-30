// https://leetcode.com/problems/continuous-subarray-sum/

import java.util.HashMap;
import java.util.Map;

public class Cp0523 {
    public static void main(String args[]) {
        Cp0523 cp = new Cp0523();
        int[] nums = {23, 13};
        boolean result = cp.checkSubarraySum(nums, 13);
        System.out.println(result);
    }

    // Main idea: array, prefix sum.
    // Time: O(n).
    // Space: O(n).
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % k;
            if (!map.containsKey(prefix)) {
                map.put(prefix, i);
            } else if (i - map.get(prefix) > 1) {
                return true;
            }
        }
        return false;
    }
}
