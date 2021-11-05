// https://leetcode.com/problems/distant-barcodes/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Cp1054 {
    public static void main(String args[]) {
        Cp1054 cp = new Cp1054();
        int[] barcodes = {2,2,2,1,5};
        int[] result = cp.rearrangeBarcodes(barcodes);
        for (int code : result) {
            System.out.print(code);
        }
    }

    // Main idea: heap.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int code : barcodes) {
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] previous = null;
        int[] result = new int[barcodes.length];
        int index = 0;
        while (index < barcodes.length) {
            int[] cur = pq.poll();
            result[index] = cur[0];
            if (previous != null) {
                pq.add(previous);
                previous = null;
            }
            if (--cur[1] != 0) {
                previous = cur;
            }
            index++;
        }
        return result;
    }
}
