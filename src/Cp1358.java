// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

public class Cp1358 {
    public static void main(String args[]) {
        Cp1358 cp = new Cp1358();
        int result = cp.numberOfSubstrings("abcabc");
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int numberOfSubstrings(String s) {
        return atMost(s.toCharArray(), 3) - atMost(s.toCharArray(), 2);
    }

    private int atMost(char[] arr, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int[] count = new int[3];
        while (right < arr.length) {
            if (count[arr[right]-'a'] == 0) {
                k--;
            }
            count[arr[right]-'a']++;
            right++;
            while (k < 0) {
                count[arr[left] - 'a']--;
                if (count[arr[left] - 'a'] == 0) {
                    k++;
                }
                left++;
            }
            result += right -  left;
        }
        return result;
    }
}
