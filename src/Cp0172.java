// https://leetcode.com/problems/factorial-trailing-zeroes/

public class Cp0172 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(log(n)).
    // Space: O(1).
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
