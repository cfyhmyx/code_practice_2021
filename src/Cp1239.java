// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp1239 {
    public static void main(String args[]) {
        Cp1239 cp = new Cp1239();
        List<String> arr = Arrays.asList("cha", "r", "act", "ers");
        int result = cp.maxLength(arr);
        System.out.print(result);
    }

    private int result = 0;

    // Main idea: backtracking, bit.
    // Time: O(2^n).
    // Space: O(n).
    public int maxLength(List<String> arr) {
        List<Integer> newArr = new ArrayList<>();
        for (String str : arr) {
            int mask = 0;
            for (char ch : str.toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            if (Integer.bitCount(mask) != str.length()) continue;
            newArr.add(mask);
        }
        helper(newArr, 0, 0);
        return result;
    }

    private void helper(List<Integer> newArr, int mask, int start) {
        result = Math.max(result, Integer.bitCount(mask));
        for (int i=start; i<newArr.size(); i++) {
            if ((mask & newArr.get(i)) == 0) {
                helper(newArr, mask|newArr.get(i), i+1);
            }
        }
    }
}
