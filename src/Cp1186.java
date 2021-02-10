// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

public class Cp1186 {
    public static void main(String args[]) {
        Cp1186 cp = new Cp1186();
        int[] nums = {1, -2, 0, 3};
        int result = cp.maximumSum(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int maximumSum(int[] arr) {
        int dp_1 = 0;
        int dp_0 = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp_1 = Math.max(dp_0, dp_1 + arr[i]);
            dp_0 = Math.max(dp_0 + arr[i], arr[i]);
            result = Math.max(result, Math.max(dp_0, dp_1));
        }
        return result;
    }
}
