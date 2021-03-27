// https://leetcode.com/problems/sentence-screen-fitting/

public class Cp0418 {
    public static void main(String args[]) {
        Cp0418 cp = new Cp0418();
        String[] sentence = {"a", "bcd", "e"};
        int result = cp.wordsTyping(sentence, 3, 6);
        System.out.println(result);
    }

    // Main idea: string.
    // Time: O(m*n + rows).
    // Space: O(m*n), m is the sentence length, n is the average string length.
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 0) {
            return 0;
        }
        // convert string array to a string sentence with space between every word
        String str = String.join(" ", sentence) + " ";
        int n = str.length();
        int lenSum = 0;
        for (int i = 0; i < rows; i++) {
            lenSum += cols;
            if (str.charAt(lenSum % n) == ' ') {
                lenSum++;
            } else {
                while (lenSum > 0 && str.charAt((lenSum - 1) % n) != ' ') {
                    lenSum--;
                }
            }
        }
        return lenSum / n;
    }

    /*private int result = 0;

    public int wordsTyping(String[] sentence, int rows, int cols) {
        helper(0, sentence, rows, cols, cols);
        return result;
    }

    private void helper(int index, String[] sentence, int row, int col, int cols) {
        if (index == sentence.length) {
            result++;
            index = 0;
        }
        if (row == 0) {
            return;
        }
        if (sentence[index].length() > col) {
            row--;
            col = cols;
        } else {
            col -= sentence[index].length() + 1;
            index++;
            if (col <= 0) {
                row--;
                col = cols;
            }
        }
        helper(index, sentence, row, col, cols);
    }*/
}
