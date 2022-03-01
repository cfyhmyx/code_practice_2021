// https://leetcode.com/problems/add-bold-tag-in-string/]

public class Cp0616 {
    public static void main(String args[]) {
    }

    // Main idea: array
    // Time: O(m*n).
    // Space: O(m).
    public String addBoldTag(String s, String[] words) {
        if (words == null) return "";

        boolean[] marked = new boolean[s.length()];
        for (String word : words) {
            markWords(s, word, marked);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (marked[i] && (i == 0 || !marked[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (marked[i] && (i == s.length() - 1 || !marked[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    void markWords(String s, String word, boolean[] marked) {
        for (int i = 0; i <= s.length() - word.length(); i++) {
            String substr = s.substring(i, i + word.length());
            if (substr.equals(word)) {
                for (int j = i; j < i + word.length(); j++) {
                    marked[j] = true;
                }
            }
        }
    }
}
