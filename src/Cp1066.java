// https://leetcode.com/problems/campus-bikes-ii/

public class Cp1066 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, memorization.
    // Time: O(b*w*2^b).
    // Space: O(w * 2^b).
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[][] dp = new int[workers.length][1 << bikes.length];
        return solve(0, 0, workers, bikes, dp);
    }

    public int solve(int cur, int takenBits, int[][] workers, int[][] bikes, int[][] dp) {
        if (cur == workers.length) return 0;
        else if (dp[cur][takenBits] != 0) return dp[cur][takenBits];
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < bikes.length; i++) {
            if ((takenBits & 1 << i) != 0) continue;
            int dist = Math.abs(workers[cur][0] - bikes[i][0]) + Math.abs(workers[cur][1] - bikes[i][1]);
            best = Math.min(best, dist + solve(cur + 1, takenBits | (1 << i), workers, bikes, dp));
        }
        dp[cur][takenBits] = best;
        return best;
    }
}
