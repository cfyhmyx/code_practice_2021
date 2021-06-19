// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/

import java.util.Arrays;

public class Cp1898 {
    public static void main(String args[]) {
        Cp1898 cp = new Cp1898();
        String s = "abcab";
        String p = "ab";
        int[] removable = {3, 1, 0};
        int result = cp.maximumRemovals(s, p, removable);
        System.out.print(result);
    }

    // Main idea: binary search.
    // Time: O(log(n) * avg(s.length)), n is the length of removable.
    // Space: O(s.length).
    public int maximumRemovals(String s, String p, int[] removable) {
        char letters[] = s.toCharArray();
        int left = 0;
        int right = removable.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            for (int i = 1; i <= mid; i++) {
                letters[removable[i-1]] = '/';
            }
            if (valid(letters, p)) {
                left = mid;
            } else {
                for (int i = 1; i <= mid; i++) {
                    letters[removable[i-1]] = s.charAt(removable[i-1]);
                }
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean valid(char letters[], String p) {
        int i = 0;
        int j = 0;
        while (i < letters.length && j < p.length()) {
            if (letters[i] == p.charAt(j)) j++;
            i++;
        }
        return j == p.length();
    }
}
