// https://leetcode.com/problems/next-permutation/

public class Cp0031 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: init: O(n).
    // Space: O(1).
    public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        int firstSmall = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        for(int i=nums.length-1; i>firstSmall; i--) {
            if(nums[i] > nums[firstSmall]) {
                swap(nums, i, firstSmall);
                break;
            }
        }
        reverse(nums, firstSmall+1, nums.length-1);
        return;
    }

    private void reverse(int[] nums, int low, int high) {
        while(low<high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
