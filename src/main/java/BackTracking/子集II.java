package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/13 上午12:56
 */
/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

path不可以包含重复元素
 */
public class 子集II {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//去重 必须排序！！
        result.add(new ArrayList<>());
        dfs(nums, 0);
        return result;
    }

    public void dfs(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            //不允许出现重复的path==set去重作用
            if (i > start && nums[i - 1] == nums[i]) continue;
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
