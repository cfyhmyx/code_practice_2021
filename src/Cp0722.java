// https://leetcode.com/problems/remove-comments/

import java.util.ArrayList;
import java.util.List;

public class Cp0722 {
    public static void main(String args[]) {
    }

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean block = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (block) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        block = false;
                        i++;        //skip '/' on next iteration of i
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      //ignore remaining characters on line s
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        block = true;
                        i++;           //skip '*' on next iteration of i
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!block && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return res;
    }
}
