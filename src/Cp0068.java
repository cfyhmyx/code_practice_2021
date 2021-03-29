// https://leetcode.com/problems/text-justification/

import java.util.ArrayList;
import java.util.List;

public class Cp0068 {
    public static void main(String args[]) {

    }

    // Main idea: string.
    // Time: O(n).
    // Space: O(maxWidth).
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int next = index + 1;
            while (next < words.length) {
                if (words[next].length() + count + 1 > maxWidth) break;
                count += words[next].length() + 1;
                next++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);

            int spaceGroup = next - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (next == words.length || spaceGroup == 0) {
                for (int i = index + 1; i < next; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / spaceGroup; //doesn't include that origin space we counted
                int rest = (maxWidth - count) % spaceGroup;
                for (int i = index + 1; i < next; i++) {
                    for (int k = spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    if (rest > 0) {
                        builder.append(" ");
                        rest--;
                    }
                    builder.append(" ");    //the origin space
                    builder.append(words[i]);
                }
            }
            lines.add(builder.toString());
            index = next;
        }
        return lines;
    }
}
