// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

public class Cp1343 {
    public static void main(String args[]) {
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int result = 0;
        for (; right < k - 1; right++) {
            curSum += arr[right];
        }
        int minSum = k * threshold;
        while (right < arr.length) {
            curSum += arr[right];
            if (curSum >= minSum) {
                result++;
            }
            right++;
            curSum -= arr[left];
            left++;
        }
        return result;
    }

}
