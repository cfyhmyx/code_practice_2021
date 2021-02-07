// https://leetcode.com/problems/freedom-trail/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0514 {
    public static void main(String args[]) {
        Cp0514 cp = new Cp0514();
        int result = cp.findRotateSteps("godding", "gd");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m*(n^2)).
    // Space: O(n*m), m is the length of key, n is the length of ring.
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        List<Integer>[] map = new List[26];
        for (int i = 0; i < n; i++) {
            int index = ring.charAt(i) - 'a';
            if (map[index] == null) {
                map[index] = new ArrayList<>();
            }
            map[index].add(i);
        }
        for (int pos : map[key.charAt(0)-'a']) {
            dp[0][pos] = Math.min(pos, n-pos);
        }
        for (int i=1; i<m; i++) {
            for (int curPos : map[key.charAt(i)-'a']) {
                for (int prePos : map[key.charAt(i-1)-'a']) {
                    int diff = Math.min(Math.abs(curPos - prePos), n - Math.abs(curPos - prePos));
                    dp[i][curPos] = Math.min(dp[i][curPos], dp[i-1][prePos] + diff);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int pos : map[key.charAt(m-1)-'a']) {
            result = Math.min(result, dp[m-1][pos]);
        }
        return result + m;
    }

    // Main idea: dfs, memorization.
    // Time: O(?).
    // Space: O(n*m), m is the length of key, n is the length of ring.
    /*public int findRotateSteps(String ring, String key) {
        Map<String,Integer> map = new HashMap();
        return dfs(ring, key, 0, map);
    }

    public int dfs(String ring, String key, int index, Map<String,Integer> map){
        if(index == key.length()){
            return 0;
        }
        char c = key.charAt(index);
        String hashKey = ring + index;
        if(map.containsKey(hashKey)) return map.get(hashKey);
        int minSteps = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i ++){
            if(ring.charAt(i) == c){
                String s = ring.substring(i) + ring.substring(0, i);
                int steps = 1 + Math.min(i, ring.length() - i);
                steps += dfs(s, key, index + 1, map);
                minSteps = Math.min(minSteps, steps);
            }
        }
        map.put(hashKey, minSteps);
        return minSteps;
    }*/
}
