// https://leetcode.com/problems/video-stitching/

import java.util.Arrays;

public class Cp1024 {
    public static void main(String args[]) {
    }

    // Main idea: greedy.
    // Time: O(nlog(n)).
    // Space: O(1).
    public int videoStitching(int[][] clips, int time) {
        int res = 0;
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        for (int i = 0, start = 0, end = 0; start < time; res++) {
            for (; i < clips.length && clips[i][0] <= start; i++) {
                end = Math.max(end, clips[i][1]);
            }
            if (start == end) return -1;
            start = end;
        }
        return res;
    }
}
