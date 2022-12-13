package Thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/10/31 3:49 PM
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "-" + Thread.currentThread().getName());
        }
    }
}

class MyThread2 implements Runnable {
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "-" + Thread.currentThread().getName());
        }
    }
}

class MyThread3 implements Callable<Integer> {
    private String name;

    public MyThread3(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        Integer sum = new Random().nextInt(10);
        return sum;
    }
}

public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        继承Thread类
//        MyThread t1 = new MyThread();
//        t1.setName("t1");
//        t1.start();
//        MyThread t2 = new MyThread();
//        t2.setName("t2");
//        t2.start();

//        实现Runnable接口
//        Runnable myt1 = new MyThread2("线程1");
//        Thread t1 = new Thread(myt1);
//        t1.start();

//        Runnable myt2 = new MyThread2("线程1");
//        Thread t2 = new Thread(myt2);
//        t2.start();


// 实例化继承Callable接口的MyThread类
        for (int i = 0; i < 3; i++) {
            MyThread3 mt = new MyThread3("线程" + (i + 1));
            FutureTask<Integer> ft = new FutureTask<Integer>(mt);
            Thread t = new Thread(ft);
            t.start();

            Integer integer = ft.get();
            System.out.println(integer);
        }


        // 手动创建线程池开启多线程
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

        //适合Runnable开启多线程
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池开启多线程打印");
            }
        });

        //适合Callable开启多线程
        threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

        //释放线程池资源
        threadPool.shutdown();
    }
}
