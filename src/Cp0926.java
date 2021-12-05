// https://leetcode.com/problems/flip-string-to-monotone-increasing/

public class Cp0926 {
    public static void main(String args[]) {
    }

    // Main idea: dp, one: the min flips end with 1, zero: the min flips end with 0;
    // Time: O(n^2).
    // Space: O(n).
    public int minFlipsMonoIncr(String s) {
        int zero = 0;
        int one = 0;
        for (Character character : s.toCharArray()) {
            if (character == '0') {
                one = Math.min(zero, one) + 1;
            } else {
                one = Math.min(one, zero);
                zero = zero + 1;
            }
        }
        return Math.min(one, zero);
    }
}
