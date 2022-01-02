// https://leetcode.com/problems/decoded-string-at-index/

public class Cp0880 {
    public static void main(String args[]) {
        Cp0880 cp = new Cp0880();
        String result = cp.decodeAtIndex("leet2code3", 10);
        System.out.println(result);
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public String decodeAtIndex(String s, int k) {
        int i;
        long N = 0;
        for (i = 0; N < k; i++) {
            N = Character.isDigit(s.charAt(i)) ? N * (s.charAt(i) - '0') : N + 1;
        }
        for (i--; i > 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                N /= s.charAt(i) - '0';
                k %= N;
            } else {
                if (k % N == 0) {
                    break;
                }
                N--;
            }
        }
        return Character.toString(s.charAt(i));
    }
}
