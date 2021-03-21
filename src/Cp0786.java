// https://leetcode.com/problems/k-th-smallest-prime-fraction/

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Cp0786 {
    public static void main(String args[]) {
        Cp0786 cp = new Cp0786();
        int[] A = {1, 2, 3, 5};
        int[] result = cp.kthSmallestPrimeFraction(A, 1);
        for (int x : result) {
            System.out.println(x);
        }
    }

    // Main idea: heap.
    // Time: max(n, k) * log(n)
    // Space: O(n).
    public int[] kthSmallestPrimeFraction(int[] a, int k) {
        int n = a.length;
        // 0: numerator idx, 1: denominator idx
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int s1 = a[o1[0]] * a[o2[1]];
                int s2 = a[o2[0]] * a[o1[1]];
                return s1 - s2;
            }
        });
        for (int i = 0; i < n-1; i++) {
            pq.add(new int[]{i, n-1});
        }
        for (int i = 0; i < k-1; i++) {
            int[] pop = pq.remove();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }

        int[] peek = pq.peek();
        return new int[]{a[peek[0]], a[peek[1]]};
    }

    // Main idea: binary search.
    // Time: ?
    // Space: O(1).
    /*public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l = 0;
        double r = 1.0;
        int n = arr.length;

        while (l < r) {
            double m = l + (r - l) / 2;

            int count = 0;
            int j = 0;
            double max = 0;
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && arr[i] > m * arr[j]) {
                    j++;
                }
                count += n - j;
                if (j == n)
                    break;
                double t = arr[i] / (double) arr[j];
                if (t > max) {
                    max = t;
                    x = i;
                    y = j;
                }
            }

            if (count == k) {
                return new int[]{arr[x], arr[y]};
            }

            if (count > k) {
                r = m;
            } else {
                l = m;
            }
        }

        return new int[]{-1, -1};
    }
    */
}
