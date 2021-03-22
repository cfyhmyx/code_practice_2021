// https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Cp0719 {
    public static void main(String args[]) {
        Cp0719 cp = new Cp0719();
        int[] nums = {1, 3, 1};
        int result = cp.smallestDistancePair(nums, 1);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: n*log(d), d is the max distance between two elements in the nums.
    // Space: O(1).
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        while (l < r) {
            int cnt = 0;
            int m = l + (r - l) / 2;
            for (int i = 0, j = 0; i < n - 1; i++) {
                while (j < n && nums[j] <= nums[i] + m) j++;
                cnt += j - i - 1;
            }
            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    // Main idea: heap.
    // Time: max(n, k) * log(n), when k is large, the method will take a lot of time.
    // Space: O(n).
    /*public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Math.abs(nums[a[0]] - nums[a[1]]) - Math.abs(nums[b[0]] - nums[b[1]])));
        for (int i = 0; i < nums.length - 1; i++) {
            pq.offer(new int[]{i, i + 1});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] cur = pq.poll();
            if (cur[1] + 1 < nums.length) {
                cur[1]++;
                pq.offer(cur);
            }
        }
        return Math.abs(nums[pq.peek()[0]] - nums[pq.peek()[1]]);
    }*/
}
