// https://leetcode.com/problems/rabbits-in-forest/

import java.util.Arrays;

public class Cp0781 {
    public static void main(String[] args) {
        Cp0781 cp = new Cp0781();
        int[] answers = {10, 10, 10, 12};
        int result = cp.numRabbits(answers);
        System.out.println(result);
    }

    // Main idea: sort
    // Time: O(n*log(n)).
    // Space: O(1).
    public int numRabbits(int[] answers) {
        int result = 0;
        Arrays.sort(answers);
        int limit = answers[0] + 1;
        int color = answers[0];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == color) {
                limit--;
            }
            if (limit == 0 || (i < answers.length - 1 && answers[i + 1] != answers[i])) {
                result += color + 1;
                if (i < answers.length - 1) {
                    color = answers[i + 1];
                    limit = color + 1;
                }
            }
        }
        if (limit != 0) {
            result += color + 1;
        }
        return result;
    }

    // Main idea: map
    // Time: O(n).
    // Space: O(n).
    /* public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num:answers){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)==1) res += num+1;
            if(map.get(num)>num) map.remove(num);
        }
        return res;
    } */
}
