// https://leetcode.com/problems/two-city-scheduling/

public class Cp1029 {
    public static void main(String args[]) {
        Cp1029 cp = new Cp1029();
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int result = cp.twoCitySchedCost(costs);
        System.out.print(result);
    }

    // Main idea: dfs, memorization.
    // Time: O(n^2).
    // Space: O(n^2).
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n + 1][n + 1];
        return helper(costs, n, n, dp);
    }

    private int helper(int[][] costs, int a, int b, int[][] dp) {
        if (a == 0 && b == 0) return 0;
        if (dp[a][b] != 0) {
            return dp[a][b];
        }
        int goA = Integer.MAX_VALUE;
        if (a > 0) {
            goA = helper(costs, a - 1, b, dp) + costs[a + b - 1][0];
        }
        int goB = Integer.MAX_VALUE;
        if (b > 0) {
            goB = helper(costs, a, b - 1, dp) + costs[a + b - 1][1];
        }
        dp[a][b] = Math.min(goA, goB);
        return dp[a][b];
    }
}
