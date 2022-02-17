// https://leetcode.com/problems/max-chunks-to-make-sorted/

public class Cp0769 {
    public static void main(String[] args) {
        Cp0769 cp = new Cp0769();
        int[] arr = {1, 0, 2, 3, 4};
        int result = cp.maxChunksToSorted(arr);
        System.out.println(result);
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}
