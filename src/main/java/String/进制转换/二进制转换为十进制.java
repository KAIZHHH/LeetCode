package String.进制转换;

/**
 * @author kai
 * @date 2022/4/24 下午7:48
 */
public class 二进制转换为十进制 {
    public static void main(String[] args) {
        int i = binaryToDecimal(1010);
        System.out.println(i);
    }

    public static int binaryToDecimal(int num) {//1010
        String str = num + "";
        int res = 0;
        int n = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int a = str.charAt(i) - '0';
            res += a * Math.pow(2, n++);
        }
        return res;

    }
}
