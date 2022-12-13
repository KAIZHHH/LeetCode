package 笔试.量锐;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/12/6 下午7:06
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String next = sc.next();
        int test = test(next);
        System.out.println(test);
    }

    public static int test(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sum++;
        }
        return sum;
    }
}
