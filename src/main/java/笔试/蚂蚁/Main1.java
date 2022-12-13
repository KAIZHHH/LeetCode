package 笔试.蚂蚁;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/18 下午2:18
 */
/*
一个字母可以拆分成两个字母表顺序的前一个字母，例如，b可以拆分成aa，c可以拆分成bb。
打印出最短的可以拆分成 K 个 a 的字符串，字母顺序无所谓。
例如，k = 5, 最短字符串为 ca(或ac) = bba = aaaaa.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                sb.append((char) ('a' + i));
            }
            i++;
            n = n >> 1;
        }
        System.out.println(sb.toString());
    }
}
