package 笔试.滴滴;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/6/11 下午8:34
 */
/*
输入的第一行是一个由小写英文字母组成的字符串s。
第二行有一个正整数n(1<=n<=100)，代表替换操作的次数。
接下来n行每行有两个以空格隔开的由小写英文字母组成的字符串t1和t2，代表你的程序需要将S中每个t1从前到后逐个替换成t2。如s=abababa，t1=aba，t2=cc，则逐个替换的结果为abababa->ccbaba->ccbcc。s中第二个aba在第一次替换中被破坏，因此只有第一个和第三个aba才会被替换成cc。
输入保证s的长度在任意一次替换前后均不会超过2000，且t1与t2的长度之和不超过100。

输出描述
输出s在n次替换操作后的结果。

样例输入
abcabc
2
bca cba
bab aca
样例输出
acacac
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);

        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s1 = sc.nextLine().split(" ");
            sb = replace(sb, s1[0], s1[1]);
        }
        System.out.println(sb.toString());
    }

    public static StringBuilder replace(StringBuilder s, String old, String New) {
        int l = 0;
        int r = 0;
        int start = 0;
        int len = 0;
        while (r < s.length()) {
            if (start < old.length() && old.charAt(start) == s.charAt(r)) {
                l = r;
                len++;
                start++;
            }
            r++;
        }
        int begin = l - len + 1;
        return s.replace(begin, l + 1, New);
    }
}
