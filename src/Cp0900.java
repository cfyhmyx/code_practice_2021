// https://leetcode.com/problems/rle-iterator/

public class Cp0900 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(n).
    class RLEIterator {

        private int[] encode;

        private int index;

        public RLEIterator(int[] encoding) {
            encode = encoding;
            index = 0;
        }

        public int next(int n) {
            while (n > 0 && index < encode.length) {
                if (n > encode[index]) {
                    n -= encode[index];
                    index = index + 2;
                } else  {
                    encode[index] -= n;
                    return encode[index + 1];
                }
            }
            return -1;
        }
    }
}
