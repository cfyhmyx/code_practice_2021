// https://leetcode.com/problems/valid-number/

public class Cp0065 {
    public static void main(String[] args) {
        Cp0065 cp = new Cp0065();
        boolean result = cp.isNumber("1E9");
        System.out.println(result);
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (Character.toLowerCase(s.charAt(i)) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && Character.toLowerCase(s.charAt(i - 1)) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
