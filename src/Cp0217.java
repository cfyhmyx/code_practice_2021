// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class Cp0217 {
    public static void main(String args[]) {
        Cp0217 cp = new Cp0217();
        int[] nums = {1, 2, 3, 1};
        boolean result = cp.containsDuplicate(nums);
        System.out.println(result);
    }

    // Main idea: set.
    // Time: O(n).
    // Space: O(n).
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
