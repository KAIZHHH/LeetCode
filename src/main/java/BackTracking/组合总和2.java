package BackTracking;

import java.util.*;

/**
 * @author kai
 * @date 2022/11/9 下午11:25
 */
public class 组合总和2 {
    static Set<List<Integer>> set = new HashSet<>();

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        List<List<Integer>> lists = combinationSum2(candidates, 5);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        res.addAll(set);
        return res;
    }

    public static void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            set.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //不允许出现candidates[i]>target 否则死循环
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            //i+1:不允许重复选择同一元素
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);

        }
    }
}
