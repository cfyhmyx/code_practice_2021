// https://leetcode.com/problems/campus-bikes/

import java.util.*;

public class Cp1057 {
    public static void main(String args[]) {
    }

    // Main idea: bucket sort.
    // Time: O(m * n).
    // Space: O(m * n).
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] buckets = new ArrayList[2001];

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = manDist(workers[i], bikes[j]);
                if (buckets[dist] == null) {
                    buckets[dist] = new ArrayList<>();
                }
                buckets[dist].add(new int[]{i, j});
            }
        }

        boolean[] bikeVisited = new boolean[bikes.length];
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        for (int dist = 0; dist < buckets.length; dist++) {
            if (buckets[dist] == null)
                continue;
            for (int i = 0; i < buckets[dist].size(); i++) {
                int w = buckets[dist].get(i)[0];
                int b = buckets[dist].get(i)[1];

                if (bikeVisited[b] == true || result[w] != -1)
                    continue;
                result[w] = b;
                bikeVisited[b] = true;
            }
        }
        return result;
    }

    public int manDist(int[] pt1, int[] pt2) {
        return Math.abs(pt1[0] - pt2[0]) + Math.abs(pt1[1] - pt2[1]);
    }
}
