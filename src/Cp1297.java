// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

import java.util.HashMap;
import java.util.HashSet;

public class Cp1297 {
    public static void main(String args[]) {
    }

    // Main idea: hashmap.
    // Time: O(n).
    // Space: O(n).
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0 || maxLetters == 0) return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            String cur = s.substring(i, i + minSize);
            if (isValid(cur, maxLetters)) {
                hm.put(cur, hm.getOrDefault(cur, 0) + 1);
                max = Math.max(max, hm.get(cur));
            }
        }
        return max;
    }

    private boolean isValid(String cur, int maxLetters) {
        HashSet<Character> hs = new HashSet<>();
        for (char c : cur.toCharArray()) hs.add(c);
        return hs.size() <= maxLetters;
    }
}
