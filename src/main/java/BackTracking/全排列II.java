package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/13 下午5:29
 */
/*
输入：nums = [1,1,2]
输出：[[1,1,2],[1,2,1],[2,1,1]]
path不允许包含重复元素

在1基础[[1,1,2],[1,2,1],[1,1,2],[1,2,1],[2,1,1],[2,1,1]]上
去重：
 */
public class 全排列II {
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();
    Boolean[] isUsed;

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new 全排列II().permuteUnique(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        isUsed = new Boolean[nums.length];
        Arrays.fill(isUsed, false);
        dfs(nums);
        return result;
    }

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == true) continue;
            if (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1] == false) continue;
            isUsed[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
            isUsed[i] = false;//回溯
        }
    }
}
