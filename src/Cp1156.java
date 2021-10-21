// https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

public class Cp1156 {
    public static void main(String args[]) {
        Cp1156 cp = new Cp1156();
        int result = cp.maxRepOpt1("aabba");
        System.out.print(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int maxRepOpt1(String text) {
        char[] charMask = new char[26];
        int max = 0;
        for (char c : text.toCharArray()) {
            charMask[c - 'a']++;
            max = Math.max(charMask[c - 'a'], max);
        }
        if (max <= 1) {
            return 1;
        }
        max = 1;
        int i = 0;
        int n = text.length();
        while (i < n) {
            int j = i;
            char cur = text.charAt(i);
            while (j < n && text.charAt(j) == cur) {
                j++;
            }
            int k = j + 1;
            while (k < n && text.charAt(k) == cur) {
                k++;
            }
            //clean up the solution:
            //"aaabaaa" . you can not find another 'a' to swap 'b'.
            //the substring(i,k) has contain all 'a'. so it's length is k-i-1.
            max = Math.max(max, (k - i - 1) == charMask[cur - 'a'] ? k - i - 1 : k - i);
            i = j;
        }
        return max;
    }
}
