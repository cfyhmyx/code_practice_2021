// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

import java.util.ArrayList;
import java.util.List;

public class Cp0524 {
    public static void main(String args[]) {
        Cp0524 cp = new Cp0524();
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        String result = cp.findLongestWord("abpcplea", d);
        System.out.println(result);
    }

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }
}
