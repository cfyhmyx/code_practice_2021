// https://github.com/cfyhmyx/code_practice/blob/master/cp055_jump_game.java

public class Cp0055 {
    public static void main(String args[]) {
        Cp0055 cp = new Cp0055();
        int[] nums = {3,2,1,0,4};
        boolean result = cp.canJump(nums);
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(n)
    // Space: O(1).
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        int last = nums.length-1;
        int reach;
        while(start <= end) {
            reach = start+nums[start];
            if(reach >= last) return true;
            end = Math.max(end, reach);
            start++;
        }
        return false;
    }
}
