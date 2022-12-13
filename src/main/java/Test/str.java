package Test;

/**
 * @author kai
 * @date 2022/8/18 下午10:14
 */


public class str {
    private static final String msg = "taobao";

    public static void main(String[] args) {
        String a = "tao" + "bao";
        String b = "tao";
        String c = "bao";
        System.out.println(a == msg);
        System.out.println((b + c) == msg);
    }
}
