package 笔试.奇安信;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/5/18 下午7:45
 */
public class Test2 {
    static int[] coins = {1, 2, 5, 10};

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int i = GiveChargeSum(100);
        System.out.println(i);
        System.out.println(res);
    }

    //回溯
    public static int GiveChargeSum(int N) {


        Arrays.sort(coins);
        dfs(coins, N, 0);
        return res.size();
    }


    public static void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //不允许出现重复的path==set去重作用
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            //不允许出现candidates[i]>target 否则死循环
            if (candidates[i] > target) break;

            path.add(candidates[i]);
            //i:不允许重复选择同一元素
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);

        }
    }
}
