// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

import java.util.HashMap;
import java.util.Map;

public class Cp1658 {
    public static void main(String args[]) {
        Cp1658 cp = new Cp1658();
        int[] nums = {1, 1};
        int result = cp.minOperations(nums, 3);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int minOperations(int[] nums, int x) {
        // Target is the middle array sum.
        int target = 0;
        for (int num : nums) target += num;
        target -= x;
        if (target == 0) return nums.length;
        if (target < 0) return -1;
        int left = 0;
        int right = 0;
        int curSum = 0;
        int length = -1;
        while (right < nums.length) {
            curSum += nums[right];
            right++;
            while (curSum > target) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == target) {
                length = Math.max(length, right - left);
            }
        }
        return length == -1 ? -1 : nums.length - length;
    }

    // Main idea: prefix sum, array.
    // Time: O(n).
    // Space: O(n).
    /*public int minOperations(int[] nums, int x) {
        int target = 0;
        for (int num : nums) target += num;
        target -= x;
        if (target == 0) return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }*/
}
