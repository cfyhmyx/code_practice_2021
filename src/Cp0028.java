// https://leetcode.com/problems/implement-strstr/

public class Cp0028 {
    public static void main(String args[]) {
    }

    // Main idea: string
    // Time: O(n).
    // Space: O(1).
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
