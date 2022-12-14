package DesignPattern.单例模式.懒汉式;

/**
 * @author kai
 * @date 2022/9/6 上午9:40
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    private static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
