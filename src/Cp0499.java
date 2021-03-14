// https://leetcode.com/problems/the-maze-iii/

import java.util.PriorityQueue;

public class Cp0499 {
    public static void main(String args[]) {
        Cp0499 cp = new Cp0499();
        int[][] maze = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1}};
        String result = cp.findShortestWay(maze, new int[]{0, 4}, new int[]{3, 5});
        System.out.println(result);
    }

    char[] dirName = {'d', 'l', 'r', 'u'};
    int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    // Main idea: Dijkstra.
    // Time: O(m*n*log(m*n))
    // Space: O(m*n).
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        Point[][] points = new Point[m][n];
        points[ball[0]][ball[1]] = new Point(ball[0], ball[1], 0, "");
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(points[ball[0]][ball[1]]);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                Point next = nextPos(maze, cur, i, hole);
                next.s = cur.s + dirName[i];
                if (points[next.x][next.y] == null || points[next.x][next.y].compareTo(next) > 0) {
                    points[next.x][next.y] = next;
                    q.offer(next);
                }
            }
        }
        if (points[hole[0]][hole[1]] == null || points[hole[0]][hole[1]].l == Integer.MAX_VALUE) {
            return "impossible";
        } else {
            return points[hole[0]][hole[1]].s;
        }
    }

    Point nextPos(int[][] maze, Point cur, int index, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        Point next = new Point(cur.x, cur.y);
        int step = 0;
        while (next.x + dirs[index][0] >= 0 && next.x + dirs[index][0] < m &&
                next.y + dirs[index][1] >= 0 && next.y + dirs[index][1] < n &&
                maze[next.x + dirs[index][0]][next.y + dirs[index][1]] != 1) {
            next.x += dirs[index][0];
            next.y += dirs[index][1];
            step++;
            if (next.x == hole[0] && next.y == hole[1]) break;
        }
        if (step != 0) {
            next.l = cur.l + step;
        }
        return next;
    }

    class Point implements Comparable<Point> {
        int x, y, l;
        String s;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.l = Integer.MAX_VALUE;
            this.s = "";
        }

        public Point(int x, int y, int l, String s) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.s = s;
        }

        public int compareTo(Point p) {
            return this.l == p.l ? s.compareTo(p.s) : this.l - p.l;
        }
    }
}
