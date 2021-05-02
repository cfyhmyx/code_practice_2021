// https://leetcode.com/problems/minimum-distance-to-the-target-element/

public class Cp5746 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: init: O(n).
    // Space: O(1).
    public int getMinDistance(int[] nums, int target, int start) {
        int left = start;
        int right = start;
        while (left >= 0 || right < nums.length) {
            if (left >= 0) {
                if (nums[left] == target) {
                    return start - left;
                }
                left--;
            }
            if (right < nums.length) {
                if (nums[right] == target) {
                    return right - start;
                }
                right++;
            }
        }
        return 0;
    }
}
