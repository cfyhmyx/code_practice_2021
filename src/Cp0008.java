public class Cp0008 {
    public static void main(String args[]) {

    }

    // Main idea: string.
    // Time: O(n).
    // Space: O(1).
    public int myAtoi(String str) {
        int factor = 1;
        double result = 0;
        int index = 0;
        for (; index < str.length(); index++) {
            if (!(str.charAt(index) == ' ')) {
                break;
            }
        }

        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            if (str.charAt(index) == '-') {
                factor = -1;
            }
            index++;
        }

        for (; index < str.length(); index++) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                result = result * 10 + str.charAt(index) - '0';
            } else {
                break;
            }
        }

        result *= factor;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
