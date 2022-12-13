package String.字符串;

/**
 * @author kai
 * @date 2022/8/5 下午11:01
 */
/*
1。找到一个不是空白的字符
2。如果第一个字符是+或者‘‘，记录下正负号
3。查看每一位，如果是数字的话就记录下来，直到出现第一个不是数字的字符
Note：如果一上来就不是‘+‘或者‘-‘或者数字，返回0
如果数字超过32位的话，返回INT_MAX或INT MIN

输入: "42"
输出: 42

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
 */
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String str = "42";
        int i = strToInt(str);
        System.out.println(i);
    }

    public static int strToInt(String str) {
        str = str.trim();
        int n = str.length();
        if (n == 0) return 0;
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        //str转int计算
        for (; index < n; index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') break;
            num = num * 10 + str.charAt(index) - '0';
            if (num > Integer.MAX_VALUE) break;
        }

        //判断特殊情况
        if (num * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) num * sign;
        }
    }
}

