package acm;

import java.util.Scanner;

public class AB5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int j = 0; j < n; j++) {
            int sum = 0;
            int s = in.nextInt();
            for (int i = 0; i < s; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }

    }
}
