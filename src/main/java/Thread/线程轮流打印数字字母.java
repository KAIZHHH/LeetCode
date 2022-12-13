package Thread;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/1 9:46 AM
 */
class print {
    private static boolean flag = true;

    //wait notify控制 该线程 执行
    public void print1() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 26; i++) {
                //flag判断：不确定是哪个线程先执行：print1()/print2()
                if (flag) {
                    char c = (char) ('a' + i);
                    System.out.println("print1: " + c);
                    flag = false;
                    this.notifyAll();
                }
                this.wait();
            }
        }
    }

    public void print2() throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i <= 26; i++) {
                if (flag) {
                    this.wait();
                }
                System.out.println("print2: " + i);
                flag = true;
                this.notifyAll();
            }
        }
    }

}

public class 线程轮流打印数字字母 {

    public static void main(String[] args) {
        print print = new print();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.print1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print.print2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
