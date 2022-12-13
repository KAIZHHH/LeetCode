package Thread;

import static java.lang.Thread.currentThread;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/7 5:22 PM
 */
class Num {
    private int Sum;//打印总次数
    private int flag;//打印标注

    public Num(int sum, int flag) {
        Sum = sum;
        this.flag = flag;
    }

    public synchronized void print(String str, int waitFlag, int nextFlag) throws InterruptedException {
        while (Sum > 0) {
            if (flag != waitFlag) {
                wait();
            }
            System.out.println(currentThread().getName() + "第" + Sum-- + "次打印" + "输出" + str);

            flag = nextFlag;
            notify();
        }
    }
}

public class 线程轮流打印数字 {
    public static void main(String[] args) {
        Num num = new Num(100, 1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    num.print("a", 1, 2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    num.print("b", 2, 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }
}
