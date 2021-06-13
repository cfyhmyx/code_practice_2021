// https://leetcode.com/problems/container-with-most-water/

public class Cp0011 {
    public static void main(String args[]) {
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start < end) {
            if (height[start] <= height[end]) {
                result = Math.max(result, height[start] * (end-start));
                start++;
            } else {
                result = Math.max(result, height[end] * (end-start));
                end--;
            }
        }
        return result;
    }
}
