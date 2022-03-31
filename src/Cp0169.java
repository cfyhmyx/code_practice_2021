// https://leetcode.com/problems/majority-element/

public class Cp0169 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == 0) {
                majority = nums[i];
                num = 1;
            } else {
                num = nums[i] == majority ? num + 1 : num - 1;
            }
        }
        return majority;
    }
}
