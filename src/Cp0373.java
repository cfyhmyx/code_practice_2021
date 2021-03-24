// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Cp0373 {
    public static void main(String args[]) {
        Cp0373 cp = new Cp0373();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> result = cp.kSmallestPairs(nums1, nums2, 3);
        System.out.println(result);
    }

    // Main idea: heap.
    // Time: k*log(k), when k is large, the method will take a lot of time.
    // Space: O(k).
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            int[] cur = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(cur[0]);
            list.add(cur[1]);
            result.add(list);
            if (cur[2] + 1 < nums2.length) {
                cur[2]++;
                cur[1] = nums2[cur[2]];
                pq.offer(cur);
            }
        }
        return result;
    }
}
