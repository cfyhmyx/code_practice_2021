// https://leetcode.com/problems/paint-house/

public class Cp0256 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int minCost(int[][] costs) {
        int color0 = costs[0][0];
        int color1 = costs[0][1];
        int color2 = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int pre0 = color0;
            int pre1 = color1;
            int pre2 = color2;
            color0 = Math.min(pre1, pre2) + costs[i][0];
            color1 = Math.min(pre0, pre2) + costs[i][1];
            color2 = Math.min(pre0, pre1) + costs[i][2];
        }
        return Math.min(color0, Math.min(color1, color2));
    }
}
