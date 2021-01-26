// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class Cp0003 {
    public static void main(String args[]) {
        Cp0003 cp = new Cp0003();
        String s = "abcabcbb";
        int result = cp.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int left = 0;
        int right = 0;
        int counter = 0;
        int result = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                counter++;
            }
            map[s.charAt(right)]++;
            right++;
            while (counter > 0) {
                if (map[s.charAt(left)] > 1) {
                    counter--;
                }
                map[s.charAt(left)]--;
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
