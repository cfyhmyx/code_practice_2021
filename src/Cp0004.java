// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class Cp0004 {
    public static void main(String args[]) {
        Cp0004 cp = new Cp0004();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double result = cp.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(m+n)).
    // Space: O(1).
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) {
            return (nums2[(n - 1) / 2] + nums2[n / 2]) / 2.0;
        }
        int left = 0;
        int right = m;
        while (left <= right) {
            // cut = x means there are x elements in the cut left.
            int cut1 = left + (right - left) / 2;
            int cut2 = (m + n) / 2 - cut1;
            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > r2) {
                right = cut1 - 1;
            } else if (l2 > r1) {
                left = cut1 + 1;
            } else {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            }
        }
        return -1;
    }
}
