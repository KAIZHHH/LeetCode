package 笔试.BOSS;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/18 下午8:47
 */
/*
牛牛想对一个数做若干次变换，直到这个数只剩下一位数 字
变换的规则是：将这个数变成所有位数上的数字的乘积。 问要需要多少次变换，使得这个数变成个位数？
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer(sc.next());
        int res = 0;
        if (sb.length() == 1) {
            res = 0;
        } else {
            while (true) {
                String str = getNum(sb.toString());
                if (str.length() != 1) {
                    res++;
                    sb.delete(0, sb.length());
                    sb.append(str);
                } else {
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }

    public static String getNum(String str) {
        int res = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            res *= num;
        }
        return res + "";
    }
}
