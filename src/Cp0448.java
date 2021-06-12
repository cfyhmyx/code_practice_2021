// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class Cp0448 {
    public static void main(String args[]) {
        Cp0448 cp = new Cp0448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = cp.findDisappearedNumbers(nums);
        System.out.println(result);
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            while (nums[i] != i+1 && nums[i] <= nums.length && nums[i] != nums[nums[i] -1]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                result.add(i+1);
            }
        }
        return result;
    }
}
