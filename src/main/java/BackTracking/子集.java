package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/12 下午2:54
 */
/*

输入：nums = [1,2,2]
输出：[[], [1], [1, 2], [1, 2, 2], [1, 2], [2], [2, 2], [2]]

path可以包含重复元素
 */

public class 子集 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    static List<List<Integer>> res = new ArrayList();
    static List<Integer> path = new ArrayList();

    public static List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList());
        dfs(nums, 0);
        return res;
    }

    public static void dfs(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList(path));
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
