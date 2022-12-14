package DesignPattern.单例模式.破坏单例方式.反射;

import DesignPattern.单例模式.双检锁.Singleton;

import java.lang.reflect.Constructor;

//反射破坏单例模式
class Test1 {
    public static void main(String[] args) throws Exception {
        Class SingletonClass = Singleton.class;
        // 通过类拿到无参构造器
        Constructor constructor = SingletonClass.getDeclaredConstructor();
        // 将构造器权限改为true
        constructor.setAccessible(true);

        Singleton instance = Singleton.getInstance();
        Singleton newInstance = (Singleton) constructor.newInstance();

        System.out.println("初始实例：" + instance);
        System.out.println("反射得到的实例：" + newInstance);
        System.out.println(instance == newInstance);
    }
}
