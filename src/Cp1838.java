// https://leetcode.com/contest/weekly-contest-238/problems/frequency-of-the-most-frequent-element/

import java.util.Arrays;

public class Cp1838 {
    public static void main(String args[]) {
    }

    // Main idea: slide window.
    // Time: O(n*log(n)).
    // Space: O(1).
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int result = 0;
        long sum = 0;
        while (right < nums.length) {
            int candidate = nums[right];
            sum += candidate;
            right++;
            while (sum + k < (long) candidate * (right - left)) {
                sum -= nums[left];
                left++;
            }
            result = Math.max(result, right-left);
        }
        return result;
    }
}
