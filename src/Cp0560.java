// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

public class Cp0560 {
    public static void main(String args[]) {
        Cp0560 cp = new Cp0560();
        int[] nums = {1, 1, 1};
        int result = cp.subarraySum(nums, 2);
        System.out.print(result);
    }

    // Main idea: array, prefix sum, map.
    // Time: O(n).
    // Space: O(n).
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int prefix = 0;
        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k)) {
                result += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return result;
    }
}
