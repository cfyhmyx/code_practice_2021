// https://leetcode.com/problems/friends-of-appropriate-ages/

public class Cp0825 {
    public static void main(String args[]) {

    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(n).
    public int numFriendRequests(int[] ages) {
        int[] nums = new int[121], sums = new int[121];
        for (int age : ages) nums[age]++;
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i];
        int res = 0;
        for (int i = 15; i < sums.length; i++) {
            if (nums[i] == 0) continue;
            int count = sums[i] - sums[i / 2 + 7];
            res += (count - 1) * nums[i];
        }
        return res;
    }
}
