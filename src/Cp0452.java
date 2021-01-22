import java.util.Arrays;

public class Cp0452 {
    public static void main(String args[]) {
        Cp0452 cp = new Cp0452();
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int result = cp.findMinArrowShots(points);
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(n*log(n)).
    // Space: O(1).
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (int[] pointA, int[] pointB) -> Integer.compare(pointA[1], pointB[1]));
        int boundary = points[0][1];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > boundary) {
                boundary = points[i][1];
                result++;
            }
        }
        return result;
    }
}
