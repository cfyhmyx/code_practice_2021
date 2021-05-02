import java.math.BigInteger;

public class Cp5747 {
    public static void main(String args[]) {
    }

    // Main idea: backtracking.
    // Time: init: O(n^2), it only has one change to get the next string.
    // Space: O(n).
    public boolean splitString(String s) {
        return helper(s, 0, null);
    }

    private boolean helper(String s, int start, BigInteger cur) {
        if (start == s.length()) {
            return true;
        }
        for (int end=start+1; end <= s.length(); end++) {
            BigInteger next = new BigInteger(s.substring(start, end));
            if (cur == null && end != s.length()) {
                if (helper(s, end, next)) {
                    return true;
                }
            } else {
                if (next.add(new BigInteger("1")).equals(cur)) {
                    if (helper(s, end, next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
