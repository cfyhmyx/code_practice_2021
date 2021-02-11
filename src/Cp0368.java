// https://leetcode.com/problems/largest-divisible-subset/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cp0368 {
    public static void main(String args[]) {
        Cp0368 cp = new Cp0368();
        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        List<Integer> result = cp.largestDivisibleSubset(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n).
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        index[i] = j;
                    }
                }
            }
        }
        int maxNum = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxNum) {
                maxNum = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> result = new LinkedList<>();
        result.add(nums[maxIndex]);
        while (index[maxIndex] != maxIndex) {
            maxIndex = index[maxIndex];
            result.add(0, nums[maxIndex]);
        }
        return result;
    }
}
