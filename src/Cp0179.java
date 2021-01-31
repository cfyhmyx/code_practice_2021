// https://leetcode.com/problems/largest-number/

import java.util.Arrays;

public class Cp0179 {
    public static void main(String args[]) {
        Cp0179 cp = new Cp0179();
        int[] nums = {999999998,999999997,999999999};
        String result = cp.largestNumber(nums);
        System.out.println(result);
    }

    // Main idea: sort.
    // Time: O(n*k*log(n)), n is the nums length, k is the average length of strings.
    // Space: O(n).
    public String largestNumber(int[] nums) {
        int m = nums.length;
        String[] transfer = new String[m];
        for(int i=0; i<m; i++) {
            transfer[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(transfer, (String s1, String s2)-> {
            double result = Double.parseDouble(s2 + s1) - Double.parseDouble(s1 + s2);
            if(result > 0) return 1;
            else if(result == 0) return 0;
            else return -1;
        });
        if (transfer[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : transfer) {
            sb.append(str);
        }
        return sb.toString();
    }
}
