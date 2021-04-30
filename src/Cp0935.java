// https://leetcode.com/problems/knight-dialer/

import java.util.Arrays;

public class Cp0935 {
    public static void main(String args[]) {
        Cp0935 cp = new Cp0935();
        int result = cp.knightDialer(3131);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(n).
    public int knightDialer(int n) {
        if (n == 1) return 10;
        long[] cur = new long[10];
        Arrays.fill(cur, 1);
        cur[5] = 0;
        long res = 0, M = (int) 1e9 + 7;
        int index = 1;
        while (index < n) {
            long[] next = cur.clone();
            next[0] = (cur[4] + cur[6]) % M;
            next[1] = (cur[6] + cur[8]) % M;
            next[2] = (cur[7] + cur[9]) % M;
            next[3] = (cur[4] + cur[8]) % M;
            next[4] = (cur[3] + cur[9] + cur[0]) % M;
            next[6] = (cur[1] + cur[7] + cur[0]) % M;
            next[7] = (cur[2] + cur[6]) % M;
            next[8] = (cur[1] + cur[3]) % M;
            next[9] = (cur[2] + cur[4]) % M;
            cur = next;
            index++;
        }
        for (long num : cur) {
            res = (res + num) % M;
        }
        return (int) res;
    }
}
