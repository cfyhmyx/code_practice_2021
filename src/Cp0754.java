// https://leetcode.com/problems/reach-a-number/

public class Cp0754 {
    public static void main(String[] args) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
