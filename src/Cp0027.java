// https://leetcode.com/problems/remove-element/

public class Cp0027 {
    public static void main(String args[]) {
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public int removeElement(int[] nums, int val) {
        int m = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[m] = nums[i];
                m++;
            }
        }
        return m;
    }
}
