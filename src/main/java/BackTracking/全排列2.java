package BackTracking;

import java.util.*;

/**
 * @author kai
 * @date 2022/5/11 上午11:07
 */

/*


输入nums = [1,1,2]
全排列1：[[1, 1, 2], [1, 2, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 1, 1]]
path允许包含重复元素


全排列2：[[1,1,2],[1,2,1],[2,1,1]]
去重：set
path不允许包含重复元素



 */
public class 全排列2 {
    Set<List<Integer>> set = new HashSet<>();

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Boolean[] isUsed;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isUsed = new Boolean[nums.length];
        Arrays.fill(isUsed, false);
        dfs(nums);
        res.addAll(set);
        return res;
    }

    public void dfs(int[] nums) {
        if (nums.length == path.size()) {
            set.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == true) continue;
            isUsed[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
            isUsed[i] = false;
        }
    }
}
