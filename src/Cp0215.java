// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Cp0215 {
    public static void main(String args[]) {
        Cp0215 cp = new Cp0215();
        int[] nums = {10, 8, 5, 6, 3, 1, 2};
        int result = cp.findKthLargest(nums, 4);
        System.out.println(result);
    }

    // Main idea: quick sort.
    // Time: O(n), worst: O(n^2).
    // Space: O(1).
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int swap = nums[mid];
            nums[mid] = nums[high];
            nums[high] = swap;
            int pivot = nums[high];
            int smallerIndex = low - 1;
            for (int i = low; i < high; i++) {
                if (nums[i] <= pivot) {
                    smallerIndex++;
                    int temp = nums[smallerIndex];
                    nums[smallerIndex] = nums[i];
                    nums[i] = temp;
                }
            }
            int temp = nums[smallerIndex + 1];
            nums[smallerIndex + 1] = pivot;
            nums[high] = temp;

            if (smallerIndex + 1 == nums.length - k) return pivot;
            else if (smallerIndex + 1 < nums.length - k) {
                low = smallerIndex + 2;
            } else {
                high = smallerIndex;
            }
        }
        return nums[low];
    }
}
