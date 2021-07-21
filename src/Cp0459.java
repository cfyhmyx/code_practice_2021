// https://leetcode.com/problems/repeated-substring-pattern/

public class Cp0459 {
    public static void main(String args[]) {
    }

    // Main idea: kmp.
    // Time: O(n).
    // Space: O(n).
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        char[] pattern = s.toCharArray();
        int index = 0;
        for (int i = 1; i < s.length(); ) {
            if (pattern[i] == pattern[index]) {
                next[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = next[index - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }
        return next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }
}
