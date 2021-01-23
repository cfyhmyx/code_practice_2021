// https://leetcode.com/problems/queue-reconstruction-by-height/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cp0406 {
    public static void main(String args[]) {
        Cp0406 cp = new Cp0406();
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = cp.reconstructQueue(people);
        for (int i=0; i<result.length; i++) {
            for (int j=0; j<result[0].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Main idea: greedy.
    // Time: O(n*log(n)).
    // Space: O(1).
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] people1,
                             int[] people2) -> (people1[0] == people2[0] ?
                people1[1] - people2[1] : people2[0] - people1[0]));
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
