package Thread;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/1 9:39 AM
 */


class PrintThread extends Thread {
    private String name;

    public PrintThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " : " + i);
        }
    }
}

public class 线程a执行完才开始线程b线程b执行完才开始线程c {
    public static void main(String[] args) throws InterruptedException {
        PrintThread t1 = new PrintThread("a");
        PrintThread t2 = new PrintThread("b");
        PrintThread t3 = new PrintThread("c");

            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();
    }

}

