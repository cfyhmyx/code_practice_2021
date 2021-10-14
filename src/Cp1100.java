// https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/

public class Cp1100 {
    public static void main(String args[]) {
        Cp1100 cp = new Cp1100();
        int result = cp.numKLenSubstrNoRepeats("havefunonleetcode", 5);
        System.out.print(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1), n is the number of people.
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;
        if (k == 1) return s.length();
        int[] map = new int[26];
        int count = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            if (map[s.charAt(right) - 'a']++ == 1) {
                count++;
            }
            right++;
            while (count > 0) {
                if (map[s.charAt(left) - 'a']-- == 2) {
                    count--;
                }
                left++;
            }
            if (right - left >= k) {
                result++;
            }
        }
        return result;
    }
}
