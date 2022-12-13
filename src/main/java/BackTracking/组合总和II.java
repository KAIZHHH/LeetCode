package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。

输入: candidates = [2, 3, 2, 1], target = 3,
输出:[[1, 2], [3]]
不允许重复选择同一元素、不允许出现重复的path
*/

public class 组合总和II {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        int[] candidates = {2, 3, 2, 1};

        List<List<Integer>> lists = combinationSum2(candidates, 3);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return result;
    }

    public static void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //不允许出现重复的path==set去重作用
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            //不允许出现candidates[i]>target 否则死循环
            if (candidates[i] > target) break;

            path.add(candidates[i]);
            //i+1:不允许重复选择同一元素
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);

        }
    }
}
