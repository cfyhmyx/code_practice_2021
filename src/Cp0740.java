// https://leetcode.com/problems/delete-and-earn/

public class Cp0740 {
    public static void main(String args[]) {
    }

    // Main idea: dp
    // Time: O(n).
    // Space: O(n).
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
