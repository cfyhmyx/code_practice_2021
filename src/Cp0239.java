// https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class Cp0239 {
    public static void main(String args[]) {
        Cp0239 cp = new Cp0239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = cp.maxSlidingWindow(nums, 3);
        for (int num : result) {
            System.out.print(num);
            System.out.print(" ");
        }
    }

    // Main idea: deque.
    // Time: O(n).
    // Space: O(n).
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                r[index++] = nums[q.peek()];
            }
        }
        return r;
    }

    /*public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        result[0] = pq.peek();
        for (int i = 1; i < result.length; i++) {
            int originIndex = i + k - 1;
            pq.remove(nums[originIndex - k]);
            pq.add(nums[originIndex]);
            result[i] = pq.peek();
        }
        return result;
    }*/
}
