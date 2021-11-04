// https://leetcode.com/problems/minimize-rounding-error-to-meet-target/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cp1058 {
    public static void main(String args[]) {
        Cp1058 cp = new Cp1058();
        String[] prices = {"0.700","2.800","4.900"};
        String result = cp.minimizeError(prices, 8);
        System.out.print(result);
    }

    // Main idea: math.
    // Time: O(n*log(n)).
    // Space: O(n).
    public String minimizeError(String[] prices, int target) {
        List<double[]> error = new ArrayList<>();
        double UpTarget = 0;
        for (String price : prices) {
            double cur = Double.valueOf(price);
            double up = Math.ceil(cur);
            double down = Math.floor(cur);
            UpTarget += up;
            if (up != down) {
                error.add(new double[]{up - cur, cur - down});
            }
        }
        int diff = (int) (UpTarget) - target;
        if (diff < 0 || diff > error.size()) return "-1";
        Collections.sort(error, (a, b) -> Double.compare(a[1], b[1]));
        int i = 0;
        double result = 0;
        for (; i < diff; i++) {
            result += error.get(i)[1];
        }
        for (; i < error.size(); i++) {
            result += error.get(i)[0];
        }
        return String.format("%.3f", result);
    }
}
