// https://leetcode.com/problems/find-and-replace-pattern/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0890 {
    public static void main(String args[]) {
        Cp0890 cp = new Cp0890();
        String[] words = {"ef","fq","ao","at","lx"};
        List<String> result = cp.findAndReplacePattern(words, "ya");
        System.out.println(result);
    }

    // Main idea: map.
    // Time: O(m*n).
    // Space: O(m+n).
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<String, Boolean> cache = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (!cache.containsKey(word)) {
                cache.put(word, match(word, pattern));
            }
            if (cache.get(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean match(String word, String pattern) {
        if (pattern.length() != word.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch1 = word.charAt(i);
            Character ch2 = pattern.charAt(i);
            if (map1.containsKey(ch1) && map1.get(ch1) != ch2) {
                return false;
            }
            if (map2.containsKey(ch2) && map2.get(ch2) != ch1) {
                return false;
            }
            map1.put(ch1, ch2);
            map2.put(ch2, ch1);
        }
        return true;
    }
}
