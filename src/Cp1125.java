// https://leetcode.com/problems/smallest-sufficient-team/

import java.util.*;

public class Cp1125 {
    public static void main(String args[]) {
        Cp1125 cp = new Cp1125();
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = new ArrayList<>();
        List<String> skillSet1 = new ArrayList<>();
        skillSet1.add("java");
        List<String> skillSet2 = new ArrayList<>();
        skillSet2.add("nodejs");
        List<String> skillSet3 = new ArrayList<>();
        skillSet3.add("nodejs");
        skillSet3.add("reactjs");
        people.add(skillSet1);
        people.add(skillSet2);
        people.add(skillSet3);
        int[] result = cp.smallestSufficientTeam(req_skills, people);
        for (int num : result) {
            System.out.println(num);
        }
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        int[] p2s = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int skillSet = 0;
            for (String skill : people.get(i)) {
                if (!map.containsKey(skill)) continue;
                skillSet += (1 << map.get(skill));
            }
            p2s[i] = skillSet;
        }
        int n = req_skills.length;
        List<Integer>[] saves = new List[1 << n];
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < people.size(); i++) {
            int[] dp2 = dp.clone();
            for (int skillSet = 0; skillSet < (1 << n); skillSet++) {
                int newSkillSet = skillSet | p2s[i];
                if (dp2[newSkillSet] > dp[skillSet] + 1) {
                    dp2[newSkillSet] = dp[skillSet] + 1;
                    if (saves[skillSet] == null) {
                        saves[skillSet] = new ArrayList<>();
                    }
                    saves[newSkillSet] = new ArrayList<>(saves[skillSet]);
                    saves[newSkillSet].add(i);
                }
            }
            dp = dp2.clone();
        }
        int[] result = new int[saves[(1 << n) - 1].size()];
        for (int i = 0; i < saves[(1 << n) - 1].size(); i++) {
            result[i] = saves[(1 << n) - 1].get(i);
        }
        return result;
    }
}
