package Test;

/**
 * @author kai
 * @date 2022/9/5 下午1:00
 */
class Config {
    public static String name;

    static {
        name = "BBBB";
    }

    {
        name = "AAAA";
    }

}

public class Test {
    public static void main(String[] args) {
        System.out.println(Config.name);
    }
}
