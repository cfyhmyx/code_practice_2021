// https://leetcode.com/problems/domino-and-tromino-tiling/

public class Cp0790 {
    public static void main(String[] args) {
    }

    // Main idea: dp
    // Time: O(n).
    // Space: O(1).
    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        int M = 1000000007;
        for (int i = 3; i <= n; i++) {
            int cur = (((c * 2) % M) + a) % M;
            a = b;
            b = c;
            c = cur;
        }
        return c;
    }
}
