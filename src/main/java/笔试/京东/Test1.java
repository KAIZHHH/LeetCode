package 笔试.京东;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/27 下午7:32
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        String test = test(n, k, str);
        System.out.println(test);

    }

    private static String test(int n, int k, String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (i < k) {
                if (c >= 'a' && c <= 'z') {//小写
                    char c1 = (char) (c - 32);
                    sb.append(c1);
                } else {//大写
                    sb.append(c);
                }
            } else {
                if (c >= 'A' && c <= 'Z') {//大写
                    char c1 = (char) (c + 32);
                    sb.append(c1);
                } else {//小写
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
