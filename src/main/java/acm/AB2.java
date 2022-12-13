package acm;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 上午9:34
 */
/*
输入描述:
输入第一行包括一个数据组数t(1 <= t <= 100)
接下来每行包括两个正整数a,b(1 <= a, b <= 1000)

输出描述:
输出a+b的结果

2
1 5
10 20

6
30
 */
public class AB2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

