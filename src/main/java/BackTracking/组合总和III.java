package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/11 上午12:17
 */
/*
找出所有相加之和为 n 的 k 个数的组合。
组合中只允许含有 1 - 9 的正整数，
并且每种组合中不存在重复的数字      ->剪枝 自己：定义start

输入: k = 3, n = 7
输出: [[1,2,4]]

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class 组合总和III {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 9);
        System.out.println(lists);

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 1);
        return result;
    }

    /**
     * @param n          为相加之和
     * @param k          个数字
     * @param startIndex
     */
    private static void dfs(int n, int k, int startIndex) {
        //每加一个数 n对应相减 直到为0 证明 满足
        //每用一个数 k对应相减 直到为0 证明 满足
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            dfs(n - i, k - 1, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
