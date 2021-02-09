// https://leetcode.com/problems/minimum-falling-path-sum-ii/

public class Cp1289 {
    public static void main(String args[]) {
        Cp1289 cp = new Cp1289();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int result = cp.minFallingPathSum(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m*n).
    // Space: O(m*n).
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[0][i];
            if (dp[0][i] < min) {
                secondMin = min;
                min = dp[0][i];
                minIndex = i;
            } else if (dp[0][i] < secondMin) {
                secondMin = dp[0][i];
            }
        }
        for (int i = 1; i < m; i++) {
            int localMin = Integer.MAX_VALUE;
            int localMinIndex = -1;
            int localSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (j != minIndex) {
                    dp[i][j] = arr[i][j] + min;
                } else {
                    dp[i][j] = arr[i][j] + secondMin;
                }
                if (dp[i][j] < localMin) {
                    localSecondMin = localMin;
                    localMin = dp[i][j];
                    localMinIndex = j;
                } else if (dp[i][j] < localSecondMin) {
                    localSecondMin = dp[i][j];
                }
            }
            min = localMin;
            minIndex = localMinIndex;
            secondMin = localSecondMin;
        }
        return min;
    }
}
