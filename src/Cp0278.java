// https://leetcode.com/problems/first-bad-version/

public class Cp0278 {
    public static void main(String args[]) {
        Cp0278 cp = new Cp0278();
        int result = cp.firstBadVersion(5);
        System.out.println(result);
    }
    
    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    // Fake method.
    private boolean isBadVersion(int version) {
        return true;
    }
}
