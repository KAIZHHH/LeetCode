package 笔试.数字马力;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/10/15 下午6:33
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int test = test(s);
        System.out.println(test);
    }

    private static int test(String s) {
        String[] s1 = s.split(" ");
        int length = s1[s1.length - 1].length();
        return length;
    }
}
