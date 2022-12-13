package Thread;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/7 3:24 PM
 */
class Station extends Thread {
    static int sum = 100;//票数
    static Object lock = "lock";

    public Station(String name) {
        super(name);// 给线程名字赋值
    }

    @Override
    public void run() {
        while (sum > 0) {
            synchronized (lock) {//不加锁 同一时刻多个线程同时卖出票
                if (sum > 0) {
                    System.out.println(currentThread().getName() + "卖出第" + sum + "张票");
                    sum--;
                }
            }
        }
    }
}

public class 线程随机卖票 {
    public static void main(String[] args) {
        new Station("窗口1").start();
        new Station("窗口2").start();
        new Station("窗口3").start();

    }
}
