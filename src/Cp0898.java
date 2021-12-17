// https://leetcode.com/problems/bitwise-ors-of-subarrays/

import java.util.HashSet;
import java.util.Set;

public class Cp0898 {
    public static void main(String args[]) {
    }

    // Main idea: set, math.
    // Time: O(kn).
    // Space: O(n).
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> pre = new HashSet<>();
        for (int i : A) {
            Set<Integer> cur = new HashSet<>();
            cur.add(i);
            set.add(i);
            for (int p : pre) {
                cur.add(p | i);
                set.add(p | i);
            }
            pre = cur;
        }
        return set.size();
    }
}
