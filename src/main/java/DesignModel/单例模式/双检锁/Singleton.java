package DesignModel.单例模式.双检锁;

/**
 * @author kai
 * @date 2022/3/16 下午9:43
 */
public class Singleton {
    private static volatile Singleton instance;

    //private：限制其他类中使用new Singleton()构造对象
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {  // 线程A和线程B同时看到singleton = null，如果不为null，则直接返回singleton
            synchronized (Singleton.class) { // 线程A或线程B获得该锁进行初始化
                if (instance == null) { // 其中一个线程进入该分支，另外一个线程则不会进入该分支
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    //添加此方法后，解决反序列化的问题
    private Object readResolve() {
        return instance;
    }


    public static void main(String[] args) {
        Singleton instance = getInstance();
        System.out.println(instance);
    }
}
