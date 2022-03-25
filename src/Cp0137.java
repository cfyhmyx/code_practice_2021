// https://leetcode.com/problems/single-number-ii/

public class Cp0137 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
