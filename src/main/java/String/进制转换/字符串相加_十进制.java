package String.进制转换;

/**
 * @author kai
 * @date 2022/4/24 下午6:24
 */
public class 字符串相加_十进制 {
    public static void main(String[] args) {
        String num1 = "001";
        String num2 = "6";
        String s = addStrings(num1, num2);
        System.out.println(Integer.valueOf(s));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;//carry代表进位数 初始是1
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        return sb.reverse().toString();
    }
}
