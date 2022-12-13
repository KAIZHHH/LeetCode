package BackTracking;

import java.util.*;

/**
 * @author kai
 * @date 2022/5/11 上午10:40
 */
/*
输入：nums = [1,1,2]
子集1：[[], [1], [1, 1], [1, 1, 2], [1, 2], [1], [1, 2], [2]]
path可以包含重复元素

子集2：[[1], [], [1, 1], [1, 1, 2], [2], [1, 2]]
子集1上去重
path不可以包含重复元素

 */
public class 子集2 {
    static Set<List<Integer>> set = new HashSet();
    static List<List<Integer>> res = new ArrayList();
    static List<Integer> path = new ArrayList();

    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//去重 必须排序！！
        set.add(new ArrayList());
        dfs(nums, 0);
        res.addAll(set);
        return res;
    }

    public static void dfs(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            set.add(new ArrayList(path));
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
