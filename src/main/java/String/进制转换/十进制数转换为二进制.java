package String.进制转换;

import org.junit.Test;

/**
 * @author kai
 * @date 2022/4/24 下午7:49
 */
public class 十进制数转换为二进制 {
    public static void main(String[] args) {
        int i = binaryToDecimal(55);
        System.out.println(i);
    }

    public static int binaryToDecimal(int num) {
        int n = 0;  //记录递增的2的次方
        int res = 0; //记录二进制结果
        int over = 0;  //用来存储余数
        while (num != 0) {
            over = num % 2;
            num = num / 2;
            //pow(x,y)：x的y次方
            double v = over * Math.pow(10, n++);
            res += v;
        }
        return res;
    }

    @Test
    public void test(int num) {
        int n = 0;
        int res = 0;
        int over = 0;
        while (num != 0) {
            over = num % 2;
            num = num / 2;
            double v = over * Math.pow(10, n++);
            res += v;
        }
    }
}
