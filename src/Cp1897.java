public class Cp1897 {
    public static void main(String args[]) {
        Cp1897 cp = new Cp1897();
        String[] words = {"abc", "aabc", "bc"};
        boolean result = cp.makeEqual(words);
        System.out.print(result);
    }

    // Main idea: map.
    // Time: O(n * avg(length)).
    // Space: O(1).
    public boolean makeEqual(String[] words) {
        int[] map = new int[26];
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                map[ch - 'a']++;
            }
        }
        int n = words.length;
        for (int i = 0; i < 26; i++) {
            if (map[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
}
