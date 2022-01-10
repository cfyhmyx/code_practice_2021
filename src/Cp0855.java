// https://leetcode.com/problems/exam-room/

import java.util.TreeSet;

public class Cp0855 {
    public static void main(String args[]) {
    }

    // Main idea: TreeSet
    // Time: O(log(n)).
    // Space: O(n).
    class ExamRoom {
        private TreeSet<Interval> intervals = new TreeSet<>((a, b) -> a.d == b.d ? a.x - b.x : b.d - a.d);
        private TreeSet<Integer> seats = new TreeSet();
        private int N;

        public ExamRoom(int N) {
            this.N = N;
            intervals.add(new Interval(-1, N));
        }

        public int seat() {
            int pos;
            Interval i = intervals.pollFirst();
            if(i.x == -1) {
                pos = 0;
            } else if(i.y == N) {
                pos = N - 1;
            } else {
                pos = (i.y + i.x) / 2;
            }
            seat(i, pos);
            return pos;
        }

        public void leave(int p) {
            Integer left = seats.lower(p);
            Integer right = seats.higher(p);
            left = left == null ? -1 : left;
            right = right == null ? N : right;
            seats.remove(p);
            intervals.remove(new Interval(left, p));
            intervals.remove(new Interval(p, right));
            intervals.add(new Interval(left, right));
        }


        private void seat(Interval i, int pos) {
            seats.add(pos);
            intervals.remove(i);
            intervals.add(new Interval(i.x, pos));
            intervals.add(new Interval(pos, i.y));
        }


        private class Interval{
            int x, y, d;
            public Interval(int xx, int yy) {
                x = xx;
                y = yy;
                if(x == -1) {
                    d = y;
                } else if(y == N) {
                    d = N - x - 1;
                } else {
                    d = Math.abs(x - y) / 2;
                }
            }

            @Override
            public boolean equals(Object obj) {
                Interval i = (Interval) obj;
                if(x == i.x && y == i.y) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
