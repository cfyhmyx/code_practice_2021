// https://leetcode.com/problems/number-of-1-bits/

public class Cp0191 {
    public static void main(String args[]) {
    }

    // Main idea: bit
    // Time: O(1).
    // Space: O(1).
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
