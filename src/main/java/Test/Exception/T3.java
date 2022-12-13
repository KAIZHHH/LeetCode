package Test.Exception;

/**
 * @author kai
 * @date 2022/9/5 下午2:25
 */
public class T3 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception o) {
            System.out.println("myexception");
        }
    }
}
