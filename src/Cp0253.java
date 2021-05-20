// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.PriorityQueue;

public class Cp0253 {
    public static void main(String args[]) {
    }

    // Main idea: heap.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> starts = new PriorityQueue<>();
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (int[] interval : intervals) {
            starts.add(interval[0]);
            ends.add(interval[1]);
        }
        int result = 0;
        int local = 0;
        while (!starts.isEmpty()) {
            while (!ends.isEmpty() && ends.peek() <= starts.peek()) {
                ends.poll();
                local--;
            }
            starts.poll();
            local++;
            result = Math.max(result, local);
        }
        return result;
    }
}
