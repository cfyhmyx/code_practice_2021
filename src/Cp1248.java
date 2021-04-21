// https://leetcode.com/problems/count-number-of-nice-subarrays/

public class Cp1248 {
    public static void main(String args[]) {
        Cp1248 cp = new Cp1248();
        int[] nums = {2, 2, 1, 1, 2};
        int result = cp.numberOfSubarrays(nums, 2);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int count = 0;
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                k--;
                count = 0;
            }
            right++;
            while (k == 0) {
                if (nums[left] % 2 == 1) {
                    k++;
                }
                left++;
                count++;
            }
            result += count;
        }
        return result;
    }
}
