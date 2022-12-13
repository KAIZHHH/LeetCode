package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/13 下午12:54
 */
/*

nums = [1,1,2]
[[1, 1, 2], [1, 2, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 1, 1]]

path可以包含重复元素


                                  剪枝：path中存在的数据需要跳过
                                            [1,2,3]
                              |                |                   |
                             1                 2                   3
                       |    |     |        |   |    |       |      |     |
                     （1）  2     3        1  （2）  3       1      2    (3)
                           |     |        |        |       |      |
                      (1)(2)3 (1)2(3) (1)(2)3   1(2)(3) (1)2(3) 1(2)(3)
                         123    132     213       231     312    321
     */

//定义isUsed数组
public class 全排列 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static Boolean[] isUsed;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        isUsed = new Boolean[nums.length];
        Arrays.fill(isUsed, false);
        dfs(nums);
        return result;
    }

    public static void dfs(int[] nums) {
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
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
