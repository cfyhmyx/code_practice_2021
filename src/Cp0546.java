// https://leetcode.com/problems/remove-boxes/

public class Cp0546 {
    public static void main(String args[]) {
        Cp0546 cp = new Cp0546();
        int[] nums = {2, 3, 2};
        int result = cp.removeBoxes(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^4).
    // Space: O(n^3).
    public static int removeBoxes(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return dfs(boxes, dp, 0, boxes.length-1, 0);
    }

    private static int dfs(int[] boxes, int[][][] dp, int left, int right, int number) {
        if(left > right) return 0;
        if(dp[left][right][number] != 0) return dp[left][right][number];
        //first case
        while(right>left && boxes[right] == boxes[right-1]) {
            right--;
            number++;
        }
        dp[left][right][number] = (number+1)*(number+1) + dfs(boxes, dp, left, right-1, 0);

        //second case
        for(int i=left; i<right; i++) {
            if(boxes[i] == boxes[right]) {
                dp[left][right][number] = Math.max(dp[left][right][number], dfs(boxes, dp, i+1, right-1, 0) + dfs(boxes, dp, left, i, number+1));
            }
        }
        return dp[left][right][number];
    }
}
