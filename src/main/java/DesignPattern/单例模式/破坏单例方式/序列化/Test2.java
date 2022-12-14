package DesignPattern.单例模式.破坏单例方式.序列化;

import DesignPattern.单例模式.双检锁.Singleton;

import java.io.*;

//序列化破坏
class Test2 {
    public static void main(String[] args) throws Exception {
        // 获取对象
        Singleton instance = Singleton.getInstance();

        // 将对象序列化到文件中
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singleton.txt"));
        objectOutputStream.writeObject(instance);

        // 读取文件
        File file = new File("singleton.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton) objectInputStream.readObject();

        // 判断是否为同一个对象
        System.out.println("初始对象：" + instance);
        System.out.println("反序列化后得到的对象：" + newInstance);

        System.out.println(instance == newInstance);
    }
}




