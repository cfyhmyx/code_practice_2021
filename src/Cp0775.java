// https://leetcode.com/problems/global-and-local-inversions/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cp0775 {
    public static void main(String[] args) {
        Cp0775 cp = new Cp0775();
        int[] nums = {1, 2, 0};
        boolean result = cp.isIdealPermutation(nums);
        System.out.println(result);
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public boolean isIdealPermutation(int[] nums) {
        int cmax = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            cmax = Math.max(cmax, nums[i]);
            if (cmax > nums[i + 2]) return false;
        }
        return true;
    }

    /*public boolean isIdealPermutation(int[] nums) {
        List<Integer> arr = new LinkedList<>();
        arr.add(nums[0]);
        int global = 0;
        int local = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                local++;
            }
            int insertIndex = -Collections.binarySearch(arr, nums[i]) - 1;
            if (arr.size() - insertIndex > 1) return false;
            global += arr.size() - insertIndex;
            arr.add(insertIndex, nums[i]);
        }
        return local == global;
    }*/
}
