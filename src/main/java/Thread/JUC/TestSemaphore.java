package Thread.JUC;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/10 4:12 PM
 */
public class TestSemaphore {
    public static void main(String[] args) {
        //六辆车停三个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "------抢到车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                    System.out.println(Thread.currentThread().getName() + "------离开车位");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();

        }
    }
}
