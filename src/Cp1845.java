// https://leetcode.com/contest/biweekly-contest-51/problems/seat-reservation-manager/

import java.util.PriorityQueue;

public class Cp1845 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(log(n)).
    // Space: O(n).
    class SeatManager {
        PriorityQueue<Integer> pq;

        public SeatManager(int n) {
            pq = new PriorityQueue<>();
            for (int i=1; i<=n; i++) {
                pq.add(i);
            }
        }

        public int reserve() {
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.add(seatNumber);
            return;
        }
    }
}
