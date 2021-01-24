// https://leetcode.com/problems/non-decreasing-array/

public class Cp0665 {
    public static void main(String args[]) {
        Cp0665 cp = new Cp0665();
        int[] nums = {3, 4, 2, 3};
        boolean result = cp.checkPossibility(nums);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (count == 2) {
                    return false;
                }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
