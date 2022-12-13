package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kai
 * @date 2022/11/22 下午11:03
 */
public class 两个线程相加之和 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 5000; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        new Thread(futureTask).start();
        int o = (int) futureTask.get();

        FutureTask futureTask1 = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 5000; i <= 10000; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        new Thread(futureTask1).start();
        int o1 = (int) futureTask1.get();
        System.out.println(o+o1);


    }
}
