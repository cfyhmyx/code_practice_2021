// https://leetcode.com/problems/can-place-flowers/

public class Cp0605 {
    public static void main(String args[]) {
        Cp0605 cp = new Cp0605();
        int[] flowerbed = {0, 0, 1, 0, 0};
        boolean result = cp.canPlaceFlowers(flowerbed, 1);
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(1).
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) continue;
            boolean leftClear = i == 0 ? true : flowerbed[i - 1] == 0;
            boolean rightClear = i == flowerbed.length - 1 ? true : flowerbed[i + 1] == 0;
            if (leftClear && rightClear) {
                if (--n <= 0) break;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
}
