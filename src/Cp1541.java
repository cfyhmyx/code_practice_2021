// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

import java.util.Stack;

public class Cp1541 {
    public static void main(String args[]) {
        Cp1541 cp = new Cp1541();
        int result = cp.minInsertions("()()()()()(");
        System.out.print(result);
    }

    // Main idea: string.
    // Time: O(n).
    // Space: O(1).
    public int minInsertions(String s) {
        int left = 0;
        int result = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                left++;
            } else {
                if (left == 0) {
                    result++;
                } else {
                    left--;
                }
                if (index + 1 >= s.length() || s.charAt(index + 1) != ')') {
                    result++;
                } else {
                    index++;
                }
            }
            index++;
        }
        if (left > 0) {
            result += left * 2;
        }
        return result;
    }
}
