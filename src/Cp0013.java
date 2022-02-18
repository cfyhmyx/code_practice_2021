// https://leetcode.com/problems/roman-to-integer/

import java.util.HashMap;
import java.util.Map;

public class Cp0013 {
    public static void main(String[] args) {
    }

    // Main idea: map
    // Time: O(n).
    // Space: O(1).
    public int romanToInt(String s) {
        Map<Character, Integer> myMap = new HashMap();
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X', 10);
        myMap.put('L', 50);
        myMap.put('C', 100);
        myMap.put('D', 500);
        myMap.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && myMap.get(s.charAt(i)) > myMap.get(s.charAt(i - 1))) {
                result = result - 2 * myMap.get(s.charAt(i - 1));
            }
            result += myMap.get(s.charAt(i));
        }
        return result;
    }
}
