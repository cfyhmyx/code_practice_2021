// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/

public class Cp1300 {
    public static void main(String args[]) {
        Cp1300 cp = new Cp1300();
        int[] arr = {4, 9, 3};
        int result = cp.findBestValue(arr, 10);
        System.out.print(result);
    }

    // Main idea: binary search.
    // Time: O(n * log(max)).
    // Space: O(1).
    public int findBestValue(int[] arr, int target) {
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int left = 0;
        int right = 0;
        for (int num : arr) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : arr) {
                sum += num > mid ? mid : num;
            }
            if (sum > target) {
                if (sum - target < diff) {
                    diff = sum - target;
                    result = mid;
                } else if (sum - target == diff) {
                    result = result = Math.min(result, mid);
                }
                right = mid - 1;
            } else {
                if (target - sum < diff) {
                    diff = target - sum;
                    result = mid;
                } else if (target - sum == diff) {
                    result = Math.min(result, mid);
                }
                left = mid + 1;
            }
        }
        return result;
    }
}
