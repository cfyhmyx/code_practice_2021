// https://leetcode.com/problems/longest-turbulent-subarray/

public class Cp0978 {
    public static void main(String args[]) {
        Cp0978 cp = new Cp0978();
        int[] arr = {4,8,12,16};
        int result = cp.maxTurbulenceSize(arr);
        System.out.print(result);
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int maxTurbulenceSize(int[] arr) {
        int result = 1;
        int index = 0;
        int cur = 1;
        boolean pattern = true;
        while (index < arr.length - 1) {
            if (arr[index] == arr[index + 1]) {
                result = Math.max(result, cur);
                cur = 1;
            } else {
                if (pattern) {
                    if ((index % 2 == 0 && arr[index] > arr[index + 1]) ||
                            ((index % 2 == 1) && arr[index] < arr[index + 1])) {
                        cur++;
                    } else {
                        pattern = !pattern;
                        result = Math.max(result, cur);
                        cur = 2;
                    }
                } else {
                    if ((index % 2 == 0 && arr[index] < arr[index + 1]) ||
                            ((index % 2 == 1) && arr[index] > arr[index + 1])) {
                        cur++;
                    } else {
                        pattern = !pattern;
                        result = Math.max(result, cur);
                        cur = 2;
                    }
                }
            }
            index++;
        }
        result = Math.max(result, cur);
        return result;
    }

    // Better solution.
    /*public int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }*/
}
