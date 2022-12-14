package DesignPattern.单例模式.内部类;

//内部类实现单例模式
class Singleton {
    private Singleton() {
    }

    //内部类实现单例模式
    private static class InnerClass {
        //单例对象
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton instance = getInstance();
        System.out.println(instance);
    }
}
