// https://leetcode.com/problems/monotone-increasing-digits/

public class Cp0738 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public int monotoneIncreasingDigits(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int marker = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                chars[i - 1] -= 1;
                marker = i;
            }
        }
        for (int i = marker; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}
