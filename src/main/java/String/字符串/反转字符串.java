package String.字符串;

/**
 * @author kai
 * @date 2022/8/7 下午5:52
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int n = s.length;
        int i = 0;
        int j = n - 1;
        for (; i < n / 2; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

}
