// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

public class Cp0581 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int start = -1, end = -1;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]); //from left to right, search the current max
            min = Math.min(min, nums[len - i - 1]);  //from right to left, search the current min
            if (nums[i] < max) {
                end = i;
            }
            if (nums[len - i - 1] > min) {
                start = len - i - 1;
            }
        }
        if (start == -1)
            return 0;
        return end - start + 1;
    }
}
