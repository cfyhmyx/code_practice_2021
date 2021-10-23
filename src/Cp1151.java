// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/

public class Cp1151 {
    public static void main(String args[]) {
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(n).
    public int minSwaps(int[] data) {
        int cnt = 0;
        for (int num : data) if (num == 1) cnt++;
        if (cnt == 0) return 0;
        int left = 0, zeros = 0, min = data.length;
        for (int right = 0; right < data.length; right++){
            if (data[right] == 0) zeros++;
            //if window size larger than number of 1s move left pointer
            if (right - left + 1 > cnt){
                if (data[left] == 0) zeros--;
                left++;
            }
            //for every correct window size we record the number of zeros which is the number of switch
            if (right - left + 1 == cnt) min = Math.min(min, zeros);
        }
        return min;
    }
}
