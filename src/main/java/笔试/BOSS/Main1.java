package 笔试.BOSS;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int mod = a % b;
        if (mod == 0) {
            System.out.println(a);
        } else {

            int out = getMaxMult(a, b);
            int result = a * b / out;
            System.out.println(result);
        }
    }

    private static int getMaxMult(int a, int b) {
        int m = a % b;
        while (m != 0) {
            a = b;
            b = m;
            m = a % b;
        }
        return b;
    }
}
