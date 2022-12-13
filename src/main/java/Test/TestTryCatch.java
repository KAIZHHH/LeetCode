package Test;

/**
 * @author kai
 * @date 2022/4/5 上午8:54
 */
public class TestTryCatch {
    public static void main(String[] args) {
        System.out.println("return value of getValue(): " +
                getValue());
    }

    public static int getValue() {
        try {
            return 0;
        } catch (Exception e){
            return 1;

        }
    }
}

