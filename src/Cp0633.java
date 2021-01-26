// https://leetcode.com/problems/sum-of-square-numbers/

public class Cp0633 {
    public static void main(String args[]) {
        Cp0633 cp = new Cp0633();
        boolean result = cp.judgeSquareSum(5);
        System.out.println(result);
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            if (left * left < c - right * right) {
                left++;
            } else if (left*left > c-right*right) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

}
