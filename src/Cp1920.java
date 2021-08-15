// https://leetcode.com/problems/build-array-from-permutation/

public class Cp1920 {
    public static void main(String args[]) {
        Cp1920 cp = new Cp1920();
        int[] nums = {0,2,1,5,3,4};
        int[] result = cp.buildArray(nums);
        for (int num : result) {
            System.out.println(num);
        }
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(1).
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            // nums[i] % n: old value, nums[i] / n: new value
            nums[i] = nums[i] + n*(nums[nums[i]] % n);
        }

        for(int i=0; i<n; i++){
            nums[i] = nums[i]/n;
        }

        return nums;
    }
}
