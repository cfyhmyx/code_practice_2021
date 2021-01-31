// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;
import java.util.Map;

public class Cp0219 {
    public static void main(String args[]) {
        Cp0219 cp = new Cp0219();
        int[] nums = {1, 2, 3, 1};
        boolean result = cp.containsNearbyDuplicate(nums, 2);
        System.out.println(result);
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(n).
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null && i - value <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
