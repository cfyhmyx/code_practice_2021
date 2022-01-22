// https://leetcode.com/problems/most-profit-assigning-work/

import java.util.Arrays;

public class Cp0826 {
    public static void main(String args[]) {
        Cp0826 cp = new Cp0826();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        int result = cp.maxProfitAssignment(difficulty, profit, worker);
        System.out.println(result);
    }

    // Main idea: sort
    // Time: O(nlog(n)).
    // Space: O(n).
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        Arrays.sort(worker);
        int result = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < worker.length; i++) {
            while (index < jobs.length && worker[i] >= jobs[index][0]) {
                max = Math.max(max, jobs[index][1]);
                index++;
            }
            result += max;
        }
        return result;
    }
}
