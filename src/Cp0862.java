// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

import java.util.ArrayDeque;
import java.util.Deque;

public class Cp0862 {
    public static void main(String args[]) {
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int result = Integer.MAX_VALUE;
        int[] prefixSum = new int[n+1];
        for (int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i]+A[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<n+1; i++) {
            while (dq.size()>0 && prefixSum[i]-prefixSum[dq.getFirst()] >= K) {
                result = Math.min(result, i-dq.pollFirst());
            }
            while (dq.size()>0 && prefixSum[i] <= prefixSum[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
