// https://leetcode.com/problems/stickers-to-spell-word/

import java.util.Arrays;

public class Cp0691 {
    public static void main(String args[]) {
        Cp0691 cp = new Cp0691();
        String[] stickers = {"with", "example", "science"};
        int result = cp.minStickers(stickers, "thehat");
        System.out.println(result);
    }

    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int state = 0; state < (1 << n); state++) {
            if (dp[state] == Integer.MAX_VALUE) continue;
            for (String str : stickers) {
                int new_state = helper(state, target, str);
                dp[new_state] = Math.min(dp[new_state], dp[state] + 1);
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }

    private int helper(int state, String target, String str) {
        int n = target.length();
        for (Character ch : str.toCharArray()) {
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) == 0 && target.charAt(k) == ch) {
                    state = state + (1 << k);
                    break;
                }
            }
        }
        return state;
    }
}
