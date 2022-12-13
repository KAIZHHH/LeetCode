package acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/30 下午5:23
 */
/*
输入描述:
输入有两行，第一行n

第二行是n个字符串，字符串之间用空格隔开
输出描述:
输出一行排序后的字符串，空格隔开，无结尾空格
 */
public class String1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.print(s + " ");
        }
        //}
    }

}
