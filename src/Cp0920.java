// https://leetcode.com/problems/number-of-music-playlists/

public class Cp0920 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(N*L).
    // Space: O(N*L).
    public int numMusicPlaylists(int N, int L, int K) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (N - (j - 1))) % mod;
                if (j > K) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - K)) % mod) % mod;
                }
            }
        }
        return (int) dp[L][N];
    }
}
