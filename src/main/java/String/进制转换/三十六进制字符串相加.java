package String.进制转换;

/**
 * @author kai
 * @date 2022/4/24 下午6:57
 */

/*
36进制由0-9，a-z，共36个字符表示。
要求按照加法规则计算出任意两个36进制正整数的和，如1b + 2x = 48  （解释：47+105=152）
要求：不允许使用先将36进制数字整体转为10进制，相加后再转回为36进制的做法
 */
public class 三十六进制字符串相加 {
    public static void main(String[] args) {
        String num1 = "1b";
        String num2 = "2x";
        String s = add36Strings(num1, num2);
        System.out.println(Integer.valueOf(s));
    }

    public static String add36Strings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int x = i < 0 ? 0 : getInt(num1.charAt(i--));
            int y = j < 0 ? 0 : getInt(num2.charAt(j--));
            int sum = x + y + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;

        }
        return sb.reverse().toString();
    }

    //把字符转数字 'a'->10 'z'->36
    public static int getInt(char c) {
        //字符c转ASCII的值 和 字符0转ASCII的值 比较
        int res = 0;
        //通过ASCII值确定 c是数字 还是字符
        if (c >= '0' && c <= '9') {//
            res = c - '0';//得到int的值
        } else {//不是数字 一定是 字符 a代表10 -'a'+10
            res = c - 'a' + 10;//减掉字符 再补10开始
        }
        return res;
    }


    public static char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

}
