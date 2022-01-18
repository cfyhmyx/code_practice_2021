// https://leetcode.com/problems/image-overlap/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0835 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n^4).
    // Space: O(n^2).
    public int largestOverlap(int[][] img1, int[][] img2) {
        int rows = img1.length, cols = img1[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>(); // two lists to save pixel coordinates
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) {
                if (img1[r][c] == 1) la.add(new int[]{r, c}); // save the pixel coordinates
                if (img2[r][c] == 1) lb.add(new int[]{r, c});
            }
        Map<String, Integer> map = new HashMap<>(); // map to map the vector (from a pixel in A to a pixel in B) to its count
        for (int[] pa : la) {
            for (int[] pb : lb) {
                String s = (pa[0] - pb[0]) + " " + (pa[1] - pb[1]); // get the vector from a pixel in A to a pixel in B
                map.put(s, map.getOrDefault(s, 0) + 1); // count the number of same vectors
            }
        }
        int max = 0;
        for (int count : map.values())
            max = Math.max(max, count);
        return max;
    }
}
