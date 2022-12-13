package 笔试.百度;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            System.out.println(test(str));
        }
    }

    private static boolean test(String str) {
        int n = str.length();
        char c = str.charAt(0);
        int x = 1;
        for (int i = 1; i < n; i++) {
            if (c == str.charAt(i)) x++;
        }
        if (n == x) return true;
        return false;
    }
}
