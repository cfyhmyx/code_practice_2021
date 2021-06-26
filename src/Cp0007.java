// https://leetcode.com/problems/reverse-integer/

public class Cp0007 {
    public static void main(String args[]) {
    }

    public int reverse(int x) {
        double result = 0;
        while(x != 0) {
            int num = x%10;
            x = x/10;
            result = result*10 + num;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int)result;
    }
}
