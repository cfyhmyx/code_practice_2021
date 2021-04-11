// https://leetcode.com/problems/maximum-sum-circular-subarray/

public class Cp0918 {
    public static void main(String args[]) {
        Cp0918 cp = new Cp0918();
        int[] A = {5, -3, 5};
        int result = cp.maxSubarraySumCircular(A);
        System.out.println(result);
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
