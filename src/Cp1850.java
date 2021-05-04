public class Cp1850 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: init: O(n).
    // Space: O(n).
    public int getMinSwaps(String num, int k) {
        char[] arr = num.toCharArray();
        for (int i=0; i<k; i++) {
            nextPermutation(arr);
        }
        char[] oldArr = num.toCharArray();
        return CountSteps(oldArr, arr, arr.length);
    }

    private int CountSteps(char []s1, char[] s2, int size) {
        int i = 0, j = 0;
        int count = 0;
        while (i < size) {
            j = i;

            while (s1[j] != s2[i]) {
                j += 1;
            }
            while (i < j) {
                swap(s1, j, j - 1);
                j -= 1;
                count++;
            }
            i++;
        }
        return count;
    }

    private void nextPermutation(char[] arr) {
        int firstSmall = -1;
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i]<arr[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1) {
            reverse(arr, 0, arr.length-1);
            return;
        }
        for(int i=arr.length-1; i>firstSmall; i--) {
            if(arr[i] > arr[firstSmall]) {
                swap(arr, i, firstSmall);
                break;
            }
        }
        reverse(arr, firstSmall+1, arr.length-1);
        return;
    }

    private static void reverse(char[] nums, int low, int high) {
        while(low<high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private static void swap(char[] nums, int index1, int index2) {
        char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
