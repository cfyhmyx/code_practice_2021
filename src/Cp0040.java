// https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cp0040 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!), n is the candidates length.
    // Space: O(n), backtracking recursion stack.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, result, new LinkedList<>());
        return result;
    }

    private void backtracking(int[] candidates, int start, int target, List<List<Integer>> result,
                                     LinkedList<Integer> sol) {
        if (start == candidates.length || target == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(sol));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) break;
            sol.addLast(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i], result, sol);
            sol.removeLast();
        }
    }
}
