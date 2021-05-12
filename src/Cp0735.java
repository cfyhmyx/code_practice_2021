// https://leetcode.com/problems/asteroid-collision/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cp0735 {
    public static void main(String args[]) {
        Cp0735 cp = new Cp0735();
        int[] arr = {8, -8};
        int[] result = cp.asteroidCollision(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                    int prevAsteroid = stack.pop();
                    if (Math.abs(asteroid) == prevAsteroid) {
                        asteroid = 0;
                    } else {
                        asteroid = Math.abs(asteroid) > prevAsteroid ? asteroid : prevAsteroid;
                    }
                }
            }
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    /*public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> leftAst = new ArrayList<>();
        for (int ast : asteroids) {
            if (ast > 0) {
                stack.push(ast);
            } else if (stack.empty()) {
                leftAst.add(ast);
            } else {
                boolean leftLarger = true;
                while (!stack.empty()) {
                    if (Math.abs(ast) == stack.peek()) {
                        stack.pop();
                        leftLarger = false;
                        break;
                    } else if (Math.abs(ast) < stack.peek()) {
                        leftLarger = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (leftLarger) {
                    leftAst.add(ast);
                }
            }
        }
        int n = leftAst.size() + stack.size();
        int[] result = new int[n];
        int index = 0;
        for (; index < leftAst.size(); index++){
            result[index] = leftAst.get(index);
        }
        for (int rIndex = n-1; rIndex >= index; rIndex--) {
            result[rIndex] = stack.pop();
        }
        return result;
    }*/
}
