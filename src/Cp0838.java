// https://leetcode.com/problems/push-dominoes/

public class Cp0838 {
    public static void main(String args[]) {
        Cp0838 cp = new Cp0838();
        String result = cp.pushDominoes(".L.R.");
        System.out.println(result);
    }

    // Main idea: two pointers
    // Time: O(n).
    // Space: O(n).
    public String pushDominoes(String dominoes) {
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'L') {
                if (cur == 1) {
                    int odd = (i - index) % 2;
                    int mid = index + (i - index) / 2;
                    while (index < mid) {
                        sb.append('R');
                        index++;
                    }
                    if (odd == 1) {
                        sb.append('.');
                        index++;
                    }
                }
                while (index <= i) {
                    sb.append('L');
                    index++;
                }
                cur = -1;
            } else if (dominoes.charAt(i) == 'R') {
                if (cur == 1) {
                    while (index <= i) {
                        sb.append('R');
                        index++;
                    }
                } else {
                    while (index < i) {
                        sb.append('.');
                        index++;
                    }
                    sb.append('R');
                    index++;
                }
                cur = 1;
            }
        }
        while (index < dominoes.length()) {
            if (cur == 1) {
                sb.append('R');
            } else {
                sb.append('.');
            }
            index++;
        }
        return sb.toString();
    }
}
