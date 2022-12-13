package Test.Exception;

/**
 * @author kai
 * @date 2022/9/5 下午2:13
 */
public class T2 {
    static void test() {
        try {
            System.out.println("test");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("exception");

        }finally {
            throw new RuntimeException();

        }
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (RuntimeException e) {
            System.out.println("runtime");
        }
        System.out.println("end");
    }
}
