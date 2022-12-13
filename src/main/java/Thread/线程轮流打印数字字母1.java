package Thread;

/**
 * @author kai
 * @date 2022/11/26 下午9:04
 */
class print1 {
    private static boolean flag = true;

    //wait notify控制 该线程 执行
    public void print1() throws InterruptedException {
        synchronized (print1.class) {
            for (int i = 0; i < 26; i++) {
                //flag判断：不确定是哪个线程先执行：print1()/print2()
                if (flag) {
                    char c = (char) ('a' + i);
                    System.out.println("print1: " + c);
                    flag = false;
                    print1.class.notifyAll();
                }
                print1.class.wait();
            }
        }
    }

    public void print2() throws InterruptedException {
        synchronized (print1.class) {
            for (int i = 1; i <= 26; i++) {
                if (flag) {
                    print1.class.wait();
                }
                System.out.println("print2: " + i);
                flag = true;
                print1.class.notifyAll();
            }
        }
    }

}

public class 线程轮流打印数字字母1 {

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
