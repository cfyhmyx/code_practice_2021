// https://leetcode.com/problems/alphabet-board-path/

public class Cp1138 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public String alphabetBoardPath(String target) {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            int x1 = (c - 'a') / 5;
            int y1 = (c - 'a') % 5;
            while (x1 < x) {
                x--;
                sb.append('U');
            }
            while (y1 > y) {
                y++;
                sb.append('R');
            }
            while (y1 < y) {
                y--;
                sb.append('L');
            }
            while (x1 > x) {
                x++;
                sb.append('D');
            }
            sb.append('!');
        }
        return sb.toString();
    }
}
