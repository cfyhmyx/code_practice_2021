// https://leetcode.com/problems/minimum-cost-to-connect-sticks/

import java.util.PriorityQueue;

public class Cp1167 {
    public static void main(String args[]) {
        Cp1167 cp = new Cp1167();
        int[] sticks = {5};
        int result = cp.connectSticks(sticks);
        System.out.print(result);
    }

    // Main idea: heap.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        for (int stick : sticks) {
            pq.add(stick);
        }
        int result = 0;
        while (pq.size() != 1) {
            int next = pq.poll() + pq.poll();
            result += next;
            pq.add(next);
        }
        return result;
    }
}
