// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

import java.util.LinkedList;

public class Cp1249 {
    public static void main(String args[]) {
        Cp1249 cp = new Cp1249();
        String result = cp.minRemoveToMakeValid("))((");
        System.out.println(result);
    }

    // Main idea: list.
    // Time: O(n).
    // Space: O(n).
    public String minRemoveToMakeValid(String s) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                list.addLast(new int[]{i, 0});
            } else if (s.charAt(i) == ')') {
                if (list.size() > 0 && list.getLast()[1] == 0) {
                    list.removeLast();
                } else {
                    list.addLast(new int[]{i, 1});
                }
            }
        }
        if (list.isEmpty()) {
            return s;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch != '(' && ch != ')') {
                sb.append(ch);
            } else {
                if (index < list.size() && i == list.get(index)[0]) {
                    index++;
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
