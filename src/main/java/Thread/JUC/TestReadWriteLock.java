package Thread.JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/10 4:55 PM
 */
class MyCache {
    //创建map集合
    private volatile Map<String, Object> map = new HashMap<>();
    //读写锁对象
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) throws InterruptedException {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写操作" + key);
            //暂停
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写完了" + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object get(String key) {
        rwLock.readLock().lock();
        Object res = null;
        try {
            System.out.println(Thread.currentThread().getName() + "正在读操作" + key);
            //暂停
            TimeUnit.MICROSECONDS.sleep(300);
            res = map.get(key);
            System.out.println(Thread.currentThread().getName() + "写完了" + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}

public class TestReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    myCache.put(num + "", num + "");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.get(num + "");
            }, String.valueOf(i)).start();
        }
    }
}
