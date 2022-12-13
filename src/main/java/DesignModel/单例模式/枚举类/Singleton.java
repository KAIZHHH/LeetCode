package DesignModel.单例模式.枚举类;

import java.lang.reflect.Constructor;

/**
 * @author kai
 * @date 2022/9/6 上午11:54
 */
//枚举类实现单例模式
public enum Singleton {
    INSTANCE;// 枚举里的属性相当于Singleton的实例
}

//避免通过反射创建对象
class Test1 {
    public static void main(String[] args) throws Exception {
        Class clazz = Singleton.class;
        Constructor[] cons = clazz.getDeclaredConstructors();
        for (Constructor c : cons) {
            //将私有访间域的访问级别设置pb1ic，否则会抛出异常
            c.setAccessible(true);
            System.out.println(c.newInstance() == Singleton.INSTANCE);
        }
        //Cannot reflectively create enum objects：说明反射机制创建不了该类对象
    }
}

class Test2 {
}
