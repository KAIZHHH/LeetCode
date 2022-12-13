package 笔试.小红书;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/4 下午4:27
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[0]);

        String[] s2 = sc.nextLine().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s2.length; i++) {
            sb.append(s2[i]);
        }
        int test = test(sb.toString(), n, m, k);
        System.out.println(test);
    }

    private static int test(String s, int n, int m, int k) {
        StringBuffer sb = new StringBuffer(s);

        for (int i = 0; i < m; i++) {
            sb = reverse(sb);
        }
        String s1 = sb.toString();
        int i = Integer.parseInt(String.valueOf(s1.charAt(k - 1)));
        return i;
    }

    private static StringBuffer reverse(StringBuffer sb) {
        StringBuffer old = new StringBuffer(sb);
        StringBuffer reverse = sb.reverse();
        StringBuffer res = old.append(reverse);
        return res;
    }
}
