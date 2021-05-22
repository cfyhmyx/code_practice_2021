// https://leetcode.com/problems/valid-triangle-number/

import java.util.Arrays;

public class Cp0611 {
    public static void main(String args[]) {
        Cp0611 cp = new Cp0611();
        int[] nums = {2, 4, 3, 4};
        int result = cp.triangleNumber(nums);
        System.out.print(result);
    }

    // Main idea: three pointers.
    // Time: O(n^2).
    // Space: O(1).
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int k = nums.length-1; k>1; k--) {
            int i = 0;
            int j = k-1;
            while (i<j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j-i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    /*public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] <= nums[k]) {
                        break;
                    }
                    result++;
                }
            }
        }
        return result;
    }*/
}
