package acm;

import java.util.Scanner;

/*

输入描述:
输入包括两个正整数a,b(1 <= a, b <= 1000),输入数据包括多组。

输出描述:
输出a+b的结果

1 5
10 20

6
30
 */
public class AB1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int sum=0;
            while (in.hasNextInt()){
                sum+=in.nextInt();
            }
            System.out.println(sum);
    }
}
