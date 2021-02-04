// https://leetcode.com/problems/beautiful-array/

import java.util.ArrayList;
import java.util.List;

public class Cp0932 {
    public static void main(String args[]) {
        Cp0932 cp = new Cp0932();
        int[] result = cp.beautifulArray(6);
        for (int num : result) {
            System.out.println(num);
        }
    }

    // Main idea: divide and conquer.
    // Time: O(n)?
    // Space: O(n).
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : res) {
                if (i * 2 - 1 <= N) {
                    tmp.add(i * 2 - 1);
                }
            }
            for (int i : res) {
                if (i * 2 <= N) {
                    tmp.add(i * 2);
                }
            }
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
