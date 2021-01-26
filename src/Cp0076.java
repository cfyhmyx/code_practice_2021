// https://leetcode.com/problems/minimum-window-substring/

public class Cp0076 {
    public static void main(String args[]) {
        Cp0076 cp = new Cp0076();
        String result = cp.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(m+n).
    // Space: O(1).
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (char ch : t.toCharArray()) {
            map[ch]--;
        }
        int left = 0;
        int right = 0;
        int counter = t.length();
        int start = 0;
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (map[s.charAt(right)] < 0) {
                counter--;
            }
            map[s.charAt(right)]++;
            right++;
            while (counter == 0) {
                if (length > right - left) {
                    length = right - left;
                    start = left;
                }
                map[s.charAt(left)]--;
                if (map[s.charAt(left)] < 0) {
                    counter++;
                }
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
