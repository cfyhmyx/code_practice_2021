// https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp0090 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!).
    // Space: O(n).
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, int start, List<List<Integer>> result, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
