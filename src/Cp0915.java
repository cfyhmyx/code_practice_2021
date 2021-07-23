// https://leetcode.com/problems/partition-array-into-disjoint-intervals/

public class Cp0915 {
    public static void main(String args[]) {
        Cp0915 cp = new Cp0915();
        int[] nums = {29, 33, 6, 4, 42, 0, 10, 22, 62, 16, 46, 75};
        int result = cp.partitionDisjoint(nums);
        System.out.print(result);
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int partitionDisjoint(int[] nums) {
        int max = nums[0];
        int tempMax = max;
        int result = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            tempMax = Math.max(nums[i], tempMax);
            if (nums[i] < max) {
                result = i + 1;
                max = tempMax;
            }
        }
        return result;
    }
}
