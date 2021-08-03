// https://leetcode.com/problems/longest-mountain-in-array/

public class Cp0845 {
    public static void main(String args[]) {
        Cp0845 cp = new Cp0845();
        int[] arr = {2, 3, 3, 2, 0, 2};
        int result = cp.longestMountain(arr);
        System.out.print(result);
    }

    // Main idea: array.
    // Time: O(n)
    // Space: O(1).
    public int longestMountain(int[] arr) {
        int result = 0;
        int i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i - 1] == arr[i]) {
                i++;
            }
            int up = 0;
            while (i < arr.length && arr[i - 1] < arr[i]) {
                up++;
                i++;
            }
            int down = 0;
            while (i < arr.length && arr[i - 1] > arr[i]) {
                down++;
                i++;
            }
            if (up > 0 && down > 0) {
                result = Math.max(result, up + down + 1);
            }
        }
        return result;
    }
}
