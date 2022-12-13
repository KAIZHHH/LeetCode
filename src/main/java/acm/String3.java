package acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 下午6:45
 */
/*

输入描述:
多个测试用例，每个测试用例一行。
每行通过,隔开，有n个字符，n＜100

输出描述:
对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格


a,c,bb
f,dddd
nowcoder

a,bb,c
dddd,f
nowcoder
 */
public class String3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String len = sc.nextLine();
            String[] str = len.split(",");
            Arrays.sort(str);
            for (int i = 0; i < str.length; i++) {
                if (i == str.length - 1) {
                    System.out.print(str[i]);
                } else {
                    System.out.print(str[i] + ",");
                }
            }
            System.out.println();
        }
    }
}
