package Test;

class BaseClass {
    public BaseClass() {
    }

    {
        System.out.println("I’m CodeTop.笔试.Test.BaseClass class");
    }

    static {
        System.out.println("static CodeTop.笔试.Test.BaseClass");
    }
}

public class Base extends BaseClass {
    public Base() {
    }

    {
        System.out.println("I’m CodeTop.笔试.Test.Base class");
    }

    static {
        System.out.println("static CodeTop.笔试.Test.Base");
    }

    public static void main(String[] args) {
        new Base();
    }
}
