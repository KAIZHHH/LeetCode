package Thread.JUC;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/10 3:53 PM
 */
public class TestCyclicBarrier {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("10个集齐bingo！"));
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("get!");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
