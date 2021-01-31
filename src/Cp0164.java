// https://leetcode.com/problems/maximum-gap/

import java.util.Arrays;

public class Cp0164 {
    public static void main(String args[]) {
        Cp0164 cp = new Cp0164();
        int[] nums = {5, 2, 6, 1};
        int result = cp.maximumGap(nums);
        System.out.println(result);
    }

    // Main idea: bucket sort.
    // Time: O(n).
    // Space: O(n).
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        int min = num[0];
        int max = num[0];
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // By using n-1 buckets, there will be at least one empty bucket for putting n-2 numbers (except min and max).
        int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for (int i : num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap;
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                continue;
            }
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
