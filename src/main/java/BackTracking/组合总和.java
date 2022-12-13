package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/11 下午10:16
 */
/*

输入: candidates = [2, 3, 2, 1]   target = 3
输出:[[1, 1, 1], [1, 2], [1, 2], [3]]
允许重复选择同一元素、允许出现重复的path

 */
//剪枝(定义candidates[i]>target)：解决比target大的数 直接退出
//剪枝(定义i > start && candidates[i] == candidates[i - 1])：解决[1,1,3,4]中第二个1的深度遍历 和第一个1相同 直接跳过

public class 组合总和 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 2, 1};
        List<List<Integer>> lists = combinationSum(candidates, 3);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //要排序！！！
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
            if (candidates[i] > target) continue;

            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);//i可以重复选择同一元素  i+1则不行等同于isUsed用法
            path.remove(path.size() - 1);

        }
    }
}
