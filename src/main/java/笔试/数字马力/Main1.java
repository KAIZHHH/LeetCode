package 笔试.数字马力;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/10/15 下午6:31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int test = test(s);
        System.out.println(test);
    }

    private static int test(String s) {
        int sum = 0;
        for (char c :
                s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sum++;
            }
        }
        return sum;
    }
}
