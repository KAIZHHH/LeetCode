package Thread.JUC;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/10 3:34 PM
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "同学离开教室");
                //countDownLatch-1
                countDownLatch.countDown();
            }).start();
        }
        //countDownLatch为0才执行后续
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "关门");

    }
}
