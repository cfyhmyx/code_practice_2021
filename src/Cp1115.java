// https://leetcode.com/problems/print-foobar-alternately/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cp1115 {
    public static void main(String args[]) {
    }

    // Main idea: multi thread.
    // Time: O(n).
    // Space: O(1).
    class FooBar {
        private int n;
        ReentrantLock lock = new ReentrantLock(true);
        Condition fooCondition = lock.newCondition();
        private boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                while(flag != true) fooCondition.await();
                printFoo.run();
                flag = false;
                fooCondition.signal();
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                while(flag == true) fooCondition.await();
                printBar.run();
                flag = true;
                fooCondition.signal();
                lock.unlock();
            }
        }
    }
}
