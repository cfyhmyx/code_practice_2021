// https://leetcode.com/problems/sqrtx/

public class Cp0069 {
    public static void main(String args[]) {
        Cp0069 cp = new Cp0069();
        int result = cp.mySqrt(8);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
