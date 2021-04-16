// https://leetcode.com/problems/advantage-shuffle/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Cp0870 {
    public static void main(String args[]) {
        Cp0870 cp = new Cp0870();
        int[] A = {12, 24, 8, 32};
        int[] B = {13, 25, 32, 11};
        int[] result = cp.advantageCount(A, B);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Main idea: array, heap.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n=A.length;
        int[] res= new int[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b)->b[0]-a[0]);
        for (int i=0; i<n; i++) pq.add(new int[]{B[i], i});
        int lo=0, hi=n-1;
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            int idx=cur[1], val=cur[0];
            if (A[hi]>val) res[idx]=A[hi--];
            else res[idx]=A[lo++];
        }
        return res;
    }
}
