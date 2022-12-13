package Test.Father;

/**
 * @author kai
 * @date 2022/9/5 下午1:53
 */
interface INTERFACE {
    void change();
}

class Father implements INTERFACE {

    @Override
    public void change() {

    }
}

class Child extends Father implements INTERFACE {

    @Override
    public void change() {

    }
}

public class T1 {
    public static void main(String[] args) {
        Father o = new Child();
        change(o);
        Child o1 = (Child) o;
        change(o1);
        Father f = new Father();
        change(f);

    }

    private static void change(INTERFACE i) {
        System.out.println("i am INTERFACE");

    }

    private static void change(Father f) {
        System.out.println("i am Father");
    }

    private static void change(Child c) {
        System.out.println("i am Child");
    }
}
