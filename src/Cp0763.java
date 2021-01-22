// https://leetcode.com/problems/partition-labels/

import java.util.*;

public class Cp0763 {
    public static void main(String args[]) {
        Cp0763 cp = new Cp0763();
        List<Integer> result = cp.partitionLabels("bbbbaa");
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(1).
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S.isEmpty()) return result;
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        int end = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, map[S.charAt(i)-'a']);
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    /*public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S.isEmpty()) return result;
        Map<Character, int[]> map = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            int[] area = map.get(S.charAt(i));
            if (area == null) {
                area = new int[2];
                area[0] = i;
            }
            area[1] = i;
            map.put(S.charAt(i), area);
        }
        int[][] list = new int[map.size()][2];
        int index = 0;
        for (int[] area : map.values()) {
            list[index++] = area;
        }
        Arrays.sort(list, (int[] pointA, int[] pointB) -> Integer.compare(pointA[0], pointB[0]));
        int end =  list[0][1];
        int start = 0;
        for (int i=1; i<list.length; i++) {
            if (list[i][0] > end) {
                result.add(end-start+1);
                start = list[i][0];
                end = list[i][1];
            } else {
                start = Math.min(start, list[i][0]);
                end = Math.max(end, list[i][1]);
            }
        }
        result.add(end-start+1);
        return result;
    }*/
}
