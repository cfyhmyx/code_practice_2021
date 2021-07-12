// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.PriorityQueue;
import java.util.Queue;

public class Cp0295 {
    public static void main(String args[]) {
    }

    class MedianFinder {

        private Queue<Integer> maxHeap;
        private Queue<Integer> minHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
        }

        public double findMedian() {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
