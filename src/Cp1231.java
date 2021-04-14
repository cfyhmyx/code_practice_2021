// https://leetcode.com/problems/divide-chocolate/

public class Cp1231 {
    public static void main(String args[]) {
        Cp1231 cp = new Cp1231();
        int[] sweetness = {2,2,2,2,2};
        int result = cp.maximizeSweetness(sweetness, 2);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(1).
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1;
        int right = (int) 1e9 / (K + 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int curSum = 0;
            int parts = 0;
            for (int sweet : sweetness) {
                curSum += sweet;
                if (curSum >= mid) {
                    curSum = 0;
                    parts++;
                    if (parts >= K + 1) break;
                }
            }
            if (parts >= K + 1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
