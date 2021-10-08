// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

import java.util.LinkedList;
import java.util.List;

public class Cp1104 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(log(n)).
    // Space: O(1).
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list = new LinkedList<>();
        int node_count = 1;
        int level = 1;
        while (label >= node_count * 2) {
            node_count *= 2;
            level++;
        }

        while (label != 0) {
            list.addFirst(label);
            int levelMax = ((int) Math.pow(2, level)) - 1;
            int levelMin = (int) Math.pow(2, level - 1);
            label = (levelMax + levelMin - label) / 2;
            level--;

        }
        return list;
    }
}
