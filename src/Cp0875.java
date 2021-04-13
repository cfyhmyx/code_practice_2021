// https://leetcode.com/problems/koko-eating-bananas/

public class Cp0875 {
    public static void main(String args[]) {

    }

    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(1).
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = (l + r) / 2, total = 0;
            for (int p : piles) {
                total += (p + m - 1) / m;
            }
            if (total > h) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return l;
    }
}
