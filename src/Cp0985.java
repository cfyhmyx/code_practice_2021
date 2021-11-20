// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

public class Cp0985 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(1).
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int curSum = 0;
        for (int num : nums) {
            curSum += num % 2 == 0 ? num : 0;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int pre = nums[queries[i][1]];
            int cur = pre + queries[i][0];
            if (pre % 2 == 0) {
                if (cur % 2 == 0) {
                    curSum += cur - pre;
                } else {
                    curSum -= pre;
                }
            } else {
                if (cur % 2 == 0) {
                    curSum += cur;
                }
            }
            result[i] = curSum;
            nums[queries[i][1]] = cur;
        }
        return result;
    }
}
