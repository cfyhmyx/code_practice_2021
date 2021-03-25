// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/

public class Cp0668 {
    public static void main(String args[]) {
        Cp0668 cp = new Cp0668();
        int result = cp.findKthNumber(3, 3, 5);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: m*log(m*n-1).
    // Space: O(1).
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = 1;
            for (int i = m; i >= 1; i--) {
                while (j <= n && i * j <= mid) j++;
                count += j - 1;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
