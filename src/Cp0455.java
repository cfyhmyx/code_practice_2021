// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class Cp0455 {
    public static void main(String args[]) {
        Cp0455 cp = new Cp0455();
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2, 3};
        int result = cp.findContentChildren(nums1, nums2);
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(nlog(n)).
    // Space: O(1).
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0;
        int indexS = 0;
        while (indexS < s.length && indexG < g.length) {
            if (s[indexS] >= g[indexG]) {
                indexG++;
            }
            indexS++;
        }
        return indexG;
    }
}
