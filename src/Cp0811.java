// https://leetcode.com/problems/subdomain-visit-count/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0811 {
    public static void main(String args[]) {
        Cp0811 cp = new Cp0811();
        String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = cp.subdomainVisits(arr);
        System.out.print(result);
    }

    // Main idea: string.
    // Time: O(n).
    // Space: O(n).
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String ele : cpdomains) {
            int separator = ele.indexOf(' ');
            int num = Integer.valueOf(ele.substring(0, separator));
            while (separator != -1) {
                ele = ele.substring(separator + 1);
                map.put(ele, map.getOrDefault(ele, 0) + num);
                separator = ele.indexOf('.');
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue()).append(" ").append(entry.getKey());
            result.add(sb.toString());
        }
        return result;
    }
}
