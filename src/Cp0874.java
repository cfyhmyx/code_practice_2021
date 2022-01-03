//  https://leetcode.com/problems/walking-robot-simulation/

import java.util.HashSet;
import java.util.Set;

public class Cp0874 {
    public static void main(String args[]) {
        Cp0874 cp = new Cp0874();
        int[] commands = {6, -1, -1, 6};
        int[][] obs = {};
        int result = cp.robotSim(commands, obs);
        System.out.println(result);
    }

    // Main idea: set
    // Time: O(n).
    // Space: O(n).
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "&" + obs[1]);
        }
        int x = 0;
        int y = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int result = 0;
        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 5) % 4;
            } else if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                while (cmd-- > 0) {
                    int newX = x + dirs[dir][0];
                    int newY = y + dirs[dir][1];
                    if (set.contains(newX + "&" + newY)) {
                        break;
                    }
                    x = newX;
                    y = newY;
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
