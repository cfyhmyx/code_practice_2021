// https://leetcode.com/problems/keys-and-rooms/

import java.util.*;

public class Cp0841 {
    public static void main(String args[]) {
    }

    // Main idea: bfs
    // Time: O(n).
    // Space: O(n).
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int room : rooms.get(cur)) {
                if (!visited.contains(room)) {
                    queue.add(room);
                    visited.add(room);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
