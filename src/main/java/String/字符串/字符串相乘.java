package String.字符串;

/**
 * @author kai
 * @date 2022/5/28 上午9:38
 */
/*
1234        1234     1234     1234
 567  ->       7  +     6   +    5
            8638    74040    61700
    8638
   74040
  617000


Q
 */
public class 字符串相乘 {

    public String multiply(String num1, String num2) {
        int m = num1.length() - 1;
        int carry = 1;
        String res = "0";
        for (int i = m; i >= 0; i--) {
            int num = (num1.charAt(i) - '0') * carry;
            String str = takeOne(num, num2);
            res = add(res, str);
            carry *= 10;
        }
        return res;
    }

    public String takeOne(int x, String num2) {
        int n = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 0 || carry > 0) {
            int z = n <= 0 ? 0 : num2.charAt(n--) - '0';
            int sum = z * x + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public String add(String n1, String n2) {
        int m = n1.length() - 1;
        int n = n2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (m >= 0 || n >= 0 || carry == 1) {
            int x = m <= 0 ? 0 : n1.charAt(m--) - '0';
            int y = n <= 0 ? 0 : n2.charAt(n--) - '0';
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
