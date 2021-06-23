// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

public class Cp1283 {
    public static void main(String args[]) {
    }

    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(1).
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = (int) 1e6 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            double sum = 0;
            for (int num : nums) {
                sum += Math.ceil((double)num / mid);
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
