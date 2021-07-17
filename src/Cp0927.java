// https://leetcode.com/problems/three-equal-parts/

public class Cp0927 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int oneNum = 0;
        for (int num : arr) {
            if (num == 1) {
                oneNum++;
            }
        }
        if (oneNum == 0) {
            return new int[]{0, n - 1};
        }
        if (oneNum % 3 != 0) {
            return new int[]{-1, -1};
        }

        int partOneNum = oneNum / 3;
        int[] parts = new int[3];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (count % partOneNum == 0) {
                    // Store the leading one position in each part.
                    parts[count / partOneNum] = i;
                }
                count++;
            }
        }

        while (parts[2] != n) {
            if (arr[parts[0]] != arr[parts[1]] || arr[parts[1]] != arr[parts[2]]) {
                return new int[]{-1, -1};
            }
            parts[0]++;
            parts[1]++;
            parts[2]++;
        }
        return new int[]{parts[0] - 1, parts[1]};
    }
}
