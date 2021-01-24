// https://leetcode.com/problems/merge-sorted-array/

public class Cp0088 {
    public static void main(String args[]) {
        Cp0088 cp = new Cp0088();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        cp.merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = n + m - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }
}
