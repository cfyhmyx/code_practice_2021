// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

public class Cp1482 {
    public static void main(String args[]) {
        Cp1482 cp = new Cp1482();
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        int result = cp.minDays(bloomDay, m, k);
        System.out.print(result);
    }

    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(1).
    public int minDays(int[] bloomDay, int m, int k) {
        if ((double) m * k > bloomDay.length) return -1;
        int left = 1;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int group = 0;
            int groupSize = 0;
            for (int day : bloomDay) {
                if (day <= mid) {
                    groupSize += 1;
                } else {
                    groupSize = 0;
                }
                if (groupSize >= k) {
                    group++;
                    groupSize = 0;
                }
            }
            if (group < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
