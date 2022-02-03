// https://leetcode.com/problems/number-of-matching-subsequences/

import java.util.HashMap;
import java.util.Map;

public class Cp0792 {
    public static void main(String[] args) {
    }

    // Main idea: map, string
    // Time: O(m*n).
    // Space: O(m*n).
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<String, Boolean> cache = new HashMap<>();
        for (String word : words) {
            if (cache.containsKey(word)) {
                if (cache.get(word)) result++;
            } else {
                boolean match = helper(s, word);
                cache.put(word, match);
                if (match) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean helper(String s, String w) {
        if (w.length() > s.length()) return false;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == w.charAt(index)) {
                index++;
            }
            if (index == w.length()) return true;
        }
        return false;
    }
}
