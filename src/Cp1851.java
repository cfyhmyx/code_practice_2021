import java.util.*;

public class Cp1851 {
    public static void main(String args[]) {
    }

    // Main idea: priority queue.
    // Time: init: O(n*log(n)).
    // Space: O(n).
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        List<Integer> sortedQueryIndex = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) sortedQueryIndex.add(i);
        Collections.sort(sortedQueryIndex, (a, b)->(queries[a] - queries[b]));
        int i = 0;
        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
        //[size of interval, end of interval]
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        for (int j = 0; j < queries.length; j++) {
            int query = queries[sortedQueryIndex.get(j)];
            while (i < intervals.length && intervals[i][0] <= query) {
                q.add(new int[] {intervals[i][1] - intervals[i][0]+1, intervals[i][1]});
                i++;
            }
            while (!q.isEmpty() && q.peek()[1] < query) q.poll();
            if (q.isEmpty()) {
                res[sortedQueryIndex.get(j)] = -1;
            } else {
                res[sortedQueryIndex.get(j)] = q.peek()[0];
            }
        }
        return res;
    }
}
