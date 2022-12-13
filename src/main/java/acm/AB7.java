package acm;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 上午11:11
 */
/*
输入描述:
输入数据有多组, 每行表示一组输入数据。
每行不定有n个整数，空格隔开。(1 <= n <= 100)。

输出描述:
每组数据输出求和的结果

1 2 3
4 5
0 0 0 0 0

6
9
0
 */
public class AB7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int out = 0;
            for (String num : split) {
                out += Integer.valueOf(num);
            }
            System.out.println(out);
        }
    }
}
