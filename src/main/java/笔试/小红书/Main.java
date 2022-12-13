package 笔试.小红书;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        int[] arr = new int[2 * n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            arr[2 * n - i - 1] = arr[i];
        }
        System.out.println(arr[(int)((k - 1) % (2 * n))]);
    }
}
