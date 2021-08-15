// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cp1235 {
    public static void main(String args[]) {
        Cp1235 cp = new Cp1235();
        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        int result = cp.jobScheduling(startTime, endTime, profit);
        System.out.print(result);
    }

    // Main idea: dfs. memorization.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[jobs.length];
        return dfs(0, jobs, dp);
    }

    private int dfs(int cur, int[][] jobs, int[] dp) {
        if (cur == jobs.length) {
            return 0;
        }
        if (dp[cur] != 0) {
            return dp[cur];
        }
        int next = findNext(cur, jobs);
        int inclProf = jobs[cur][2] + (next == -1 ? 0 : dfs(next, jobs, dp));
        int exclProf = dfs(cur + 1, jobs, dp);
        dp[cur] = Math.max(inclProf, exclProf);
        return Math.max(inclProf, exclProf);
    }

    private int findNext(int cur, int[][] jobs) {
        int low = cur + 1;
        int high = jobs.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(jobs[mid][0] >= jobs[cur][1]) {
                if(jobs[mid-1][0] >= jobs[cur][1]) {
                    high = mid - 1;
                }
                else {
                    return mid;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /*public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        return helper(jobs.length - 1, jobs[jobs.length-1][1], jobs, new HashMap<>());
    }

    private int helper(int index, int curTime, int[][] jobs, Map<Integer, Integer> map) {
        if (index < 0) return 0;
        if (map.containsKey(curTime)) {
            return map.get(curTime);
        }
        int localMaxProfit = 0;
        localMaxProfit = helper(index - 1, curTime, jobs, map);
        if (jobs[index][1] <= curTime) {
            localMaxProfit = Math.max(localMaxProfit, jobs[index][2] + helper(index - 1, jobs[index][0], jobs, map));
        }
        map.put(curTime, localMaxProfit);
        return localMaxProfit;
    }*/
}
