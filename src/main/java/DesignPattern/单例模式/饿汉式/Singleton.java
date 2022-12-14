package DesignPattern.单例模式.饿汉式;

/**
 * @author kai
 * @date 2022/9/6 上午9:38
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
