package Test.Exception;

/**
 * @author kai
 * @date 2022/9/5 下午1:08
 */
public class T1 {
    public static void main(String[] args) {
        try {
            aMethod(0);
        } catch (Exception e) {
            System.out.println("exception");
        }
        System.out.println("finished");
    }

    private static int aMethod(int i) throws Exception {
        try {
            return 10 / i;
        } catch (Exception e) {
            throw new Exception("exception");
        } finally {
            System.out.println("finally");
        }
    }
}
