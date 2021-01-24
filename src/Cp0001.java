// https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

public class Cp0001 {
    public static void main(String args[]) {
        Cp0001 cp = new Cp0001();
        int[] nums = {11,7,2,15};
        int[] result = cp.twoSum(nums, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(n).
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
