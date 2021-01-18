// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/

public class Cp1712 {
    public static void main(String args[]) {
        Cp1712 cp = new Cp1712();
        int[] nums = {1, 2, 2, 2, 5, 0};
        int result = cp.waysToSplit(nums);
        System.out.println(result);
    }

    // Main idea: two pointer, another way is using binary search but the time is O(nlog(n)).
    // Time: O(n).
    // Space: O(n).
    public int waysToSplit(int[] nums) {
        int result = 0;
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        for (int i = 0, left = 0, right = 0; i < n - 2; i++) {
            while (left <= i || (left < n - 1 && prefixSum[left] - prefixSum[i] < prefixSum[i])) {
                left++;
            }
            while (right < left || (right < n - 1 && prefixSum[right] - prefixSum[i] <= prefixSum[n - 1] - prefixSum[right])) {
                right++;
            }
            result = (result + right - left) % 1000000007;
        }
        return result;
    }
}
