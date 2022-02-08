// https://leetcode.com/problems/letter-case-permutation/

import java.util.ArrayList;
import java.util.List;

public class Cp0784 {
    public static void main(String[] args) {
    }

    // Main idea: dfs, backtracking
    // Time: O(2^n).
    // Space: O(n).
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, "", result);
        return result;
    }

    private void helper(String s, int index, String path, List<String> result) {
        if (index == s.length()) {
            result.add(path);
            return;
        }
        char ch = s.charAt(index);
        if (Character.isLetter(ch)) {
            helper(s, index + 1, path + Character.toUpperCase(ch), result);
            helper(s, index + 1, path + Character.toLowerCase(ch), result);
        } else {
            helper(s, index+1, path + ch, result);
        }
    }
}
