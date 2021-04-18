// https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.ArrayList;
import java.util.List;

public class Cp0438 {
    public static void main(String args[]) {
        Cp0438 cp = new Cp0438();
        List<Integer> result = cp.findAnagrams("abab", "ab");
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result  = new ArrayList<>();
        int[] map = new int[26];
        for (char ch : p.toCharArray()) {
            map[ch-'a']++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            int index = s.charAt(right)-'a';
            map[index]--;
            if (map[index] < 0) {
                count++;
            }
            right++;
            if (right - left == p.length() && count == 0) {
                result.add(left);
                map[s.charAt(left)-'a']++;
                left++;
            }
            while (count != 0) {
                int leftIndex = s.charAt(left)-'a';
                map[leftIndex]++;
                if (map[leftIndex] == 0) {
                    count--;
                }
                left++;
            }
        }
        return result;
    }
}
