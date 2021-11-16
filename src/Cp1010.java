// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

public class Cp1010 {
    public static void main(String args[]) {
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(1).
    public int numPairsDivisibleBy60(int[] time) {
        int[] reminderMap = new int[60];
        int result = 0;
        for (int t : time) {
            int curReminder = t % 60;
            result += reminderMap[(60 - curReminder) % 60];
            reminderMap[curReminder]++;
        }
        return result;
    }
}
