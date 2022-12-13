package Thread.JUC.阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = lock.newCondition();
    final int len;

    public BlockedQueue(int len) {
        this.len = len;
    }

    // 入队
    void enq(T x) {
        lock.lock();
        try {
            while (this.len == len) {
                // 等待队列不满
                notFull.await();
            }
            // add x to queue
            // 入队后,通知可出队
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 出队
    void deq() throws InterruptedException {
        lock.lock();
        try {
            while (this.len < len) {
                // 等待队列不空
                notEmpty.await();
            }
            // remove the first element from queue
            // 出队后，通知可入队
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}
