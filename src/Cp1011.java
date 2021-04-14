// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class Cp1011 {
    public static void main(String args[]) {
        Cp1011 cp = new Cp1011();
        int[] weights = {1,2,3,1,1};
        int result = cp.shipWithinDays(weights, 4);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(1).
    public int shipWithinDays(int[] weights, int D) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int d = 1;
            int curSum = 0;
            for (int weight : weights) {
                if (curSum + weight > mid) {
                    d++;
                    curSum = weight;
                } else {
                    curSum += weight;
                }
            }
            if (d > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
