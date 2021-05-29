// https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp0015 {
    public static void main(String args[]) {
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if ((high < nums.length - 1 && nums[high] == nums[high + 1]) || nums[i] + nums[low] + nums[high] > 0) {
                    high--;
                } else if ((low > i + 1 && nums[low] == nums[low - 1]) || nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                }
            }
        }
        return result;
    }
}
