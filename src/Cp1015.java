// https://leetcode.com/problems/smallest-integer-divisible-by-k/

public class Cp1015 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(k).
    // Space: O(1).
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int r = 0;
        for (int N = 1; N <= k; ++N) {
            r = (r * 10 + 1) % k;
            if (r == 0) return N;
        }
        return -1;
    }
}
