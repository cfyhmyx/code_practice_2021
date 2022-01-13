// https://leetcode.com/problems/shifting-letters/

public class Cp0848 {
    public static void main(String args[]) {
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder(s);
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        for (int i = 0; i < s.length(); i++) {
            res.setCharAt(i, (char) ((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }
        return res.toString();
    }
}
