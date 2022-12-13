package acm;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 上午10:37
 */
public class AB6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int sum = 0;
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }

}
