package Thread.JUC.阻塞队列;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {
    private int n = 100;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore notFull = new Semaphore(n);
    private Semaphore notEmpty = new Semaphore(0);

    public void product() throws InterruptedException {
        notFull.acquire();      // 缓冲区满时，生产者线程必须等待
        mutex.acquire();
        // ...
        mutex.release();
        notEmpty.release();      // 唤醒等待的消费者线程
    }

    public void consume() throws InterruptedException {
        notEmpty.acquire();      // 缓冲区空时，消费都线程等待
        mutex.acquire();
        // ...
        mutex.release();
        notFull.release();      // 唤醒等待的生产者线程
    }

    public static void main(String[] args) {

    }
}
