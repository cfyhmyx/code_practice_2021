// https://leetcode.com/problems/k-concatenation-maximum-sum/

public class Cp1191 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        long curMaxSum = arr[0] > 0 ? arr[0] : 0;
        long maxSum = curMaxSum;
        long sum = arr[0];
        for (int i = 1; i < arr.length * Math.min(k, 2); i++) {
            curMaxSum = Math.max(arr[i % arr.length], curMaxSum + arr[i % arr.length]) % mod;
            maxSum = Math.max(maxSum, curMaxSum);
            if (i < arr.length) {
                sum += arr[i];
                sum %= mod;
            }
        }
        while (sum > 0 && k > 2) {
            maxSum = (maxSum + sum) % mod;
            k--;
        }
        return (int) maxSum;
    }
}
