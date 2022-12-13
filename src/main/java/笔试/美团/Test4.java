package 笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/5/14 上午11:18
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);//n个品牌
        int k = Integer.valueOf(s[1]);//k次操作

        String[] pro = sc.nextLine().split(" ");
        //各品牌利润值
        int[] profit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            profit[i] = Integer.valueOf(pro[i - 1]);
        }

        //各品牌库存
        int[] sum = new int[n + 1];
        Arrays.fill(sum, 0);

        //进行操作
        for (int i = 0; i < k; i++) {
            String[] s1 = sc.nextLine().split(" ");
            if (s1[0].equals("Add")) {
                int a = Integer.valueOf(s1[1]);//哪个品牌
                int b = Integer.valueOf(s1[2]);//添加
                sum[a] = sum[a] + b;

            }
            if (s1[0].equals("Query")) {

                if (s1[1].equals("BestSales")) {
                    int i1 = QueryBestSales(sum);
                    System.out.println(i1);
                } else {
                    int i2 = QueryBestProfit(sum, profit);
                    System.out.println(i2);
                }
            }

        }
    }


    public static int QueryBestSales(int[] sum) {
        int res = 1;
        int max = sum[1];
        for (int i = 2; i < sum.length; i++) {
            if (sum[i] > max) {
                max = sum[i];
                res = i;
            }
        }
        return res;
    }

    public static int QueryBestProfit(int[] sum, int[] profit) {
        int res = 1;
        int max = sum[1] * profit[1];

        for (int i = 2; i < sum.length; i++) {
            if (sum[i] * profit[i] > max) {
                max = sum[i] * profit[i];
                res = i;
            }
        }
        return res;
    }
}
