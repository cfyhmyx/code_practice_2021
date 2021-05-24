// https://leetcode.com/problems/lru-cache/

import java.util.HashMap;
import java.util.Map;

public class Cp0146 {
    public static void main(String args[]) {
    }

    // Main idea: double linked list.
    // Time: O(n).
    // Space: O(1).
    class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.pre = null;

            tail = new DLinkedNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if(node == null){
                return -1; // should raise exception here.
            }

            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null){

                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                ++count;

                if(count > capacity){
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    --count;
                }
            }else{
                // update the value.
                node.value = value;
                moveToHead(node);
            }
        }


        private void moveToHead(DLinkedNode node){
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail(){
            DLinkedNode res = tail.pre;
            removeNode(res);
            return res;
        }

        private void removeNode(DLinkedNode node){
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;

            pre.post = post;
            post.pre = pre;
        }

        private void addNode(DLinkedNode node){
            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;
        }
    }
}
