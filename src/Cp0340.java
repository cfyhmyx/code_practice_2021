// Longest Substring with At Most K Distinct Characters.

public class Cp0340 {
    public static void main(String args[]) {
        Cp0340 cp = new Cp0340();
        int result = cp.lengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k >= s.length()) return s.length();
        int[] map = new int[256];
        int left = 0, right = 0, counter = 0, result = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] == 0) {
                counter++;
            }
            map[s.charAt(right)]++;
            right++;
            while (counter > k) {
                if (map[s.charAt(left)] == 1) {
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
