// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

public class Cp1061 {
    public static void main(String args[]) {
        Cp1061 cp = new Cp1061();
        String result = cp.smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.print(result);
    }

    private int[] root = new int[26];

    // Main idea: union and find.
    // Time: O(n*C).
    // Space: O(1).
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            root[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : baseStr.toCharArray()) {
            sb.append((char)('a' + find(ch - 'a')));
        }
        return sb.toString();
    }

    private void union(int c1, int c2) {
        int r1 = find(c1);
        int r2 = find(c2);
        if (r1 <= r2) {
            root[r2] = r1;
        } else {
            root[r1] = r2;
        }
    }

    private int find(int c) {
        if (c == root[c]) return c;
        return root[c] = find(root[c]);
    }
}
