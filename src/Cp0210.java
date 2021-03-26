// https://leetcode.com/problems/course-schedule-ii/submissions/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cp0210 {
    public static void main(String args[]) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list.
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        // Build the Adjacency list.
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> zeroIndegree = new LinkedList<>();
        int traversedCourse = 0;
        int[] finishOrder = new int[numCourses];

        // Initial zeroIndegree queue.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                zeroIndegree.add(i);
            }
        }

        // Traverse each vertice and edge exact once.
        while (!zeroIndegree.isEmpty()) {
            // Remove the top course in the queue.
            int currentCourse = zeroIndegree.poll();
            finishOrder[traversedCourse++] = currentCourse;
            // Decrease the related course indegree from the current course.
            for (int i = 0; i < graph[currentCourse].size(); i++) {
                indegree[graph[currentCourse].get(i)]--;
                if (indegree[graph[currentCourse].get(i)] == 0) {
                    zeroIndegree.add(graph[currentCourse].get(i));
                }
            }
        }

        return traversedCourse == numCourses ? finishOrder : new int[]{};
    }
}
