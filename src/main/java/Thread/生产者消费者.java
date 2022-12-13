package Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/10/31 5:26 PM
 */
class Stock {
    int maxSize;//最多存放
    private List<Integer> list;//存放列表

    public Stock(int maxSize, List<Integer> list) {
        this.maxSize = maxSize;
        this.list = list;
    }

    public void produce(Integer i) throws InterruptedException {
        synchronized (this) {
            //如果队列已经满了，就不要再放数据进去了，等待消费者消费
            if (list.size() == maxSize) {
                wait();
            }

            //<maxSize
            list.add(i);
            System.out.println("生产者生产了第" + i + "个商品");
            notify();

        }
    }

    public void consume(Integer i) throws InterruptedException {
        synchronized (this) {

            if (list.size() <= 0) {
                wait();
            }

            list.remove(i);
            System.out.println("消费者消费了第" + i + "个商品");
            notify();
        }
    }
}

class consumerr implements Runnable {
    private Stock stock;

    public consumerr(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                stock.consume(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class producerr implements Runnable {
    private Stock stock;

    public producerr(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                stock.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class 生产者消费者 {
    public static void main(String[] args) {
        Stock stock = new Stock(3, new ArrayList());
        consumerr consumerr = new consumerr(stock);
        producerr producerr = new producerr(stock);
        new Thread(consumerr).start();
        new Thread(producerr).start();
    }
}
