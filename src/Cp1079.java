// https://leetcode.com/problems/letter-tile-possibilities/

public class Cp1079 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(26^7), max len for tiles is 7.
    // Space: O(1).
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        return helper(count);
    }

    private int helper(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += helper(arr);
            arr[i]++;
        }
        return sum;
    }
}
