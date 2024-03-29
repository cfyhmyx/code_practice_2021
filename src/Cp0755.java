// https://leetcode.com/problems/pour-water/

public class Cp0755 {
    public static void main(String args[]) {
    }

    // Main idea: simulation.
    // Time: O(V * n).
    // Space: O(1).
    public int[] pourWater(int[] heights, int V, int K) {
        for(int i = 0; i < V; i++) {
            int cur = K;
            // Move left
            while(cur > 0 && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            // Move right
            while(cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
                cur++;
            }
            // Move left to K
            while(cur > K && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            heights[cur]++;
        }

        return heights;
    }
}
