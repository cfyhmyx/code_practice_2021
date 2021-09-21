// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

import java.util.Stack;

public class Cp1190 {
    public static void main(String args[]) {
        Cp1190 cp = new Cp1190();
        String result = cp.reverseParentheses("(u(love)i)");
        System.out.print(result);
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(n).
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
