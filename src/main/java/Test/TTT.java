package Test;

/**
 * @author kai
 * @date 2022/4/24 下午5:00
 */
public class TTT {
    public static void main(String[] args) {
        String a = "1b", b = "2x";
        String s = add36Strings(a, b);
        System.out.println(s);
    }

    public static String add36Strings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(j)) : 0;
            int sum = x + y + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    /**
     * 将十进制整数转化为 36进制字符
     *
     * @param n
     * @return
     */
    public static char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    /**
     * 将36 进制字符转化为 10进制整数
     *
     * @param c
     * @return
     */
    public static int getInt(char c) {
        if (c <= '9') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }
}
