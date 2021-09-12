// https://leetcode.com/problems/sequential-digits/

import java.util.ArrayList;
import java.util.List;

public class Cp1291 {
    public static void main(String args[]) {
        Cp1291 cp = new Cp1291();
        List<Integer> result = cp.sequentialDigits(1000, 13000);
        System.out.print(result);
    }

    // Main idea: math.
    // Time: O(1).
    // Space: O(1).
    public List<Integer> sequentialDigits(int low, int high) {
        int temp = low;
        int m = 0;
        while (temp > 0) {
            m++;
            temp /= 10;
        }
        temp = high;
        int n = 0;
        while (temp > 0) {
            n++;
            temp /= 10;
        }
        List<Integer> result = new ArrayList<>();
        for (int len = m; len <= n; len++) {
            int start = 1;
            while (start <= 9 - len + 1) {
                int number = generateNumber(start, len);
                if (number >= low && number <= high) {
                    result.add(number);
                } else if (number > high) {
                    break;
                }
                start++;
            }
        }
        return result;
    }

    private int generateNumber(int digit, int len) {
        int number = 0;
        while (len-- > 0) {
            number = number * 10 + digit++;
        }
        return number;
    }

    /*public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if (low <= 0 && high >= 0) {
            result.add(0);
        }
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        while (queue.size() > 0) {
            int curr = queue.poll();
            if (curr >= low && curr <= high) {
                result.add(curr);
            }
            int lastDigit = curr % 10;
            if (lastDigit < 9 && curr * 10 + lastDigit + 1 <= high) {
                queue.add(curr * 10 + lastDigit + 1);
            }
        }
        return result;
    }*/
}
