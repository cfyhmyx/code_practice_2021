// https://leetcode.com/problems/sort-colors/

public class Cp0075 {

    public static void main(String args[]) {
        Cp0075 cp = new Cp0075();
        int[] nums = {0,2,1};
        cp.sortColors(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public void sortColors(int[] nums) {
        int red = -1;
        int blue = nums.length;
        for(int white=0; white>red && white<blue;) {
            if(nums[white] == 0) {
                red++;
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                white++;
            } else if (nums[white] == 2){
                blue--;
                int temp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = temp;
            } else {
                white++;
            }
        }
    }
}
