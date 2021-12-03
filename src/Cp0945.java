// https://leetcode.com/problems/minimum-increment-to-make-array-unique/

import java.util.Arrays;

public class Cp0945 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(nlog(n)).
    // Space: O(1).
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0, need = 0;
        for (int a : nums) {
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return res;
    }
}
