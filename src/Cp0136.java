// https://leetcode.com/problems/single-number/

public class Cp0136 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
