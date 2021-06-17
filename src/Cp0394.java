// https://leetcode.com/problems/decode-string/

import java.util.Stack;

public class Cp0394 {
    public static void main(String args[]) {
        Cp0394 cp = new Cp0394();
        String result = cp.decodeString("3[a]2[bc]");
        System.out.print(result);
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public String decodeString(String s) {
        String cur = "";
        int num = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (Character.isLetter(ch)) {
                cur = cur + ch;
            } else if (ch == '[') {
                s1.push(num);
                num = 0;
                s2.push(cur);
                cur = "";
            } else {
                if (!s1.empty()) {
                    int count = s1.pop();
                    String temp = "";
                    for (int i=0; i<count; i++) {
                        temp += cur;
                    }
                    String pre = s2.pop();
                    cur = pre + temp;
                }
            }
        }
        return cur;
    }
}
