package acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 下午6:39
 */
/*
输入描述:
多个测试用例，每个测试用例一行。

每行通过空格隔开，有n个字符，n＜100
输出描述:
对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开

a c bb
f dddd
nowcoder

a bb c
dddd f
nowcoder
 */
public class String2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String len = sc.nextLine();
            String[] str = len.split(" ");
            Arrays.sort(str);
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
