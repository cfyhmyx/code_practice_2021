// https://leetcode.com/problems/reverse-bits/

public class Cp0190 {
    public static void main(String args[]) {
    }

    // Main idea: bit
    // Time: O(1).
    // Space: O(1).
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }
}
