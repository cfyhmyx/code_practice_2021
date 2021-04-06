// https://leetcode.com/problems/subarray-sums-divisible-by-k/

public class Cp0974 {
    public static void main(String args[]) {
    }

    // Main idea: math, array.
    // Time: O(n).
    // Space: O(K).
    public int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K];
        count[0] = 1;
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            res += count[prefix]++;
        }
        return res;
    }
}
