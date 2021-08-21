// https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

public class Cp0077 {
    public static void main(String args[]) {

    }

    // Main idea: dfs, backtracking.
    // Time: O(n!).
    // Space: O(1).
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    private static void backtracking(int n, int k, List<List<Integer>> result, List<Integer> path, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<=n; i++) {
            path.add(i);
            backtracking(n, k-1, result, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
