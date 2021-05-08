// https://leetcode.com/contest/biweekly-contest-51/problems/replace-all-digits-with-characters/

public class Cp1844 {
    public static void main(String args[]) {
        Cp1844 cp = new Cp1844();
        String result = cp.replaceDigits("a1c1e1");
        System.out.println(result);
    }

    // Main idea: string.
    // Time: O(n).
    // Space: O(n).
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                char ch = (char) (s.charAt(i-1) + (s.charAt(i) - '0'));
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
