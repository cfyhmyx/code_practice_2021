// https://leetcode.com/problems/contains-duplicate-iii/

import java.util.HashMap;
import java.util.Map;

public class Cp0220 {
    public static void main(String args[]) {
        Cp0220 cp = new Cp0220();
        int[] nums = {-4, 0};
        boolean result = cp.containsNearbyAlmostDuplicate(nums, 2, 4);
        System.out.println(result);
    }

    // Main idea: bucket sort.
    // Time: O(n).
    // Space: O(n).
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k <= 0 || t < 0) return false;
        Map<Long, Long> keyToNum = new HashMap<>();
        long div = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long key = num / div;
            if(num < 0) key--;
            if (keyToNum.containsKey(key)
                    || keyToNum.containsKey(key + 1) && keyToNum.get(key + 1) - num <= t
                    || keyToNum.containsKey(key - 1) && num - keyToNum.get(key - 1) <= t)
                return true;
            if (i >= k) keyToNum.remove((nums[i - k]) / div);
            keyToNum.put(key, num);
        }
        return false;
    }
}
