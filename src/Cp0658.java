// https://leetcode.com/problems/find-k-closest-elements/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cp0658 {
    public static void main(String args[]) {
        Cp0658 cp = new Cp0658();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> result = cp.findClosestElements(arr, 2, 5);
        System.out.print(result);
    }

    // Main idea: two pointer.
    // Time: O(n).
    // Space: O(1).
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
                lo++;
            } else {
                hi--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /*public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int position = Arrays.binarySearch(arr, x);
        if (position < 0) {
            position = -position - 1;
        }
        List<Integer> result = new ArrayList<>();
        int left = position - 1;
        int right = position;
        while (right - left <= k) {
            if (left < 0) {
                result.add(arr[right]);
                right++;
            } else if (right >= arr.length) {
                result.add(arr[left]);
                left--;
            } else if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
                result.add(arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
        }
        Collections.sort(result);
        return result;
    }*/
}
