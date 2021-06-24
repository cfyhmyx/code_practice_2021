// https://leetcode.com/problems/minimize-max-distance-to-gas-station/

public class Cp0774 {
    public static void main(String args[]) {
    }
    
    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(1).
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double left = 0, right = stations[n - 1] - stations[0];
        while (left + 1e-6 < right) {
            double mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < n - 1; i++)
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            if (count > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
