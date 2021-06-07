// https://leetcode.com/problems/task-scheduler/

public class Cp0621 {
    public static void main(String args[]) {
        Cp0621 cp = new Cp0621();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int result = cp.leastInterval(tasks, 0);
        System.out.print(result);
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(1).
    public int leastInterval(char[] tasks, int n) {
        int[] storage = new int[26];
        for (char c : tasks) {
            storage[(c - 'A')]++;
        }
        int max = 0;
        int count = 1;
        for (int num : storage) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }
        int space = (n + 1) * (max - 1) + count;
        return (space < tasks.length) ? tasks.length : space;
    }
}
