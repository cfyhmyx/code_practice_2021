// https://leetcode.com/problems/maximize-distance-to-closest-person/

public class Cp0849 {
    public static void main(String args[]) {
        Cp0849 cp = new Cp0849();
        int[] seats = {0, 1};
        int result = cp.maxDistToClosest(seats);
        System.out.println(result);
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public int maxDistToClosest(int[] seats) {
        int last = -1;
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                result = Math.max(result, last == -1 ? i - last - 1 : (i - last) / 2);
                last = i;
            }
        }
        result = Math.max(result, seats.length - 1 - last);
        return result;
    }
}
