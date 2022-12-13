package String.进制转换;

/**
 * @author kai
 * @date 2022/6/6 下午9:26
 */
/*
26
"1a"

-1
"ffffffff"
 */
public class 数字转换为十六进制数 {
    public String toHex(int _num) {
        if (_num == 0) return "0";
        long num = _num;
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            num = (long) (Math.pow(2, 32) + num);
        }
        while (num != 0) {
            long u = num % 16;
            char c = (char) (u + '0');
            if (u >= 10) c = (char) (u - 10 + 'a');
            sb.append(c);
            num /= 16;
        }
        return sb.reverse().toString();
    }
}
