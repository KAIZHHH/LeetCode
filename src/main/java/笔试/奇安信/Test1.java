package 笔试.奇安信;

import java.util.ArrayList;

/**
 * @author kai
 * @date 2022/5/18 下午7:18
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> goods = new ArrayList<>();
        goods.add(4);
        goods.add(9);
        goods.add(24);
        int i = minCheckDuration(goods);
        System.out.println(i);
    }

    public static int minCheckDuration(ArrayList<Integer> goods) {
        int[] dp = new int[goods.size() + 1];//dp[i]代表i个货物数量所需要的最短时长
        if (goods.size() == 2) {
            return Math.min(goods.get(0), goods.get(1));
        } else if (goods.size() == 3) {
            dp[1] = goods.get(0);
            dp[2] = goods.get(1);
            dp[3] = Math.min(dp[1], dp[2]) + goods.get(2);

            return Math.min(dp[2], dp[3]);
        }

        dp[0] = 0;
        dp[1] = goods.get(0);
        dp[2] = goods.get(1);
        for (int i = 3; i <= goods.size(); i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + goods.get(i - 1);

        }
        return dp[dp.length - 1];
    }
}
