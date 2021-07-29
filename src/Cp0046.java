// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cp0046 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!).
    // Space: O(n).
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new HashSet<>(), result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, HashSet<Integer> set, List<List<Integer>> result,
                                     ArrayList<Integer> path) {
        if (set.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                path.add(nums[i]);
                backtracking(nums, set, result, path);
                path.remove(path.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
