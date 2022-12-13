package acm;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 上午9:47
 */
/*
输入数据包括多组。
每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
接下来n个正整数,即需要求和的每个正整数。
 */
public class AB4 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int sum = 0;
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                sum = sum + in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
