// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

public class Cp1839 {
    public static void main(String args[]) {
        Cp1839 cp = new Cp1839();
        int result = cp.longestBeautifulSubstring("aeeeiiiioooauuuaeiou");
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(1).
    // Space: O(1).
    public int longestBeautifulSubstring(String word) {
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        int result = 0;
        int start = 0;
        while (start < word.length() - 4) {
            int last = start;
            int next = 0;
            int count = 0;
            while (last < word.length()) {
                if (next < arr.length && word.charAt(last) == arr[next]) {
                    count++;
                    next++;
                    last++;
                } else if (next > 0 && word.charAt(last) == arr[next - 1]) {
                    last++;
                } else {
                    break;
                }
            }
            if (count == 5) {
                result = Math.max(result, last - start);
            }
            if (start == last) {
                start = last + 1;
            } else {
                start = last;
            }
        }
        return result;
    }
}
