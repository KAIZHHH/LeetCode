package String.相加;

/**
 * @author kai
 * @date 2022/11/6 下午3:49
 */
/*
给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class 二进制求和 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : a.charAt(i--) - '0';
            int y = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = carry + x + y;
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
