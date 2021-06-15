// https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class Cp0016 {
    public static void main(String args[]) {
    }

    // Main idea: two pointers.
    // Time: O(n^2).
    // Space: O(1).
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int m = nums.length;
        for (int i = 0; i < m - 2; i++) {
            int low = i + 1;
            int high = m - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] > target) {
                    if (Math.abs(nums[i] + nums[low] + nums[high] - target) < distance) {
                        result = nums[i] + nums[low] + nums[high];
                        distance = Math.abs(nums[i] + nums[low] + nums[high] - target);
                    }
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < target) {
                    if (Math.abs(nums[i] + nums[low] + nums[high] - target) < distance) {
                        result = nums[i] + nums[low] + nums[high];
                        distance = Math.abs(nums[i] + nums[low] + nums[high] - target);
                    }
                    low++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
