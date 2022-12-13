package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/4/19 下午4:31
 */
/*
定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
/*
定义isUsed数组，剪枝剪掉自己
定义(n,start)，剪枝剪掉用过的
 */
public class 组合 {
    static List<List<Integer>> res = new ArrayList<>();//[       ] res.add(path)
    static List<Integer> path = new ArrayList<>();// [ [],[] ]
    static Boolean[] isUsed;

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        isUsed = new Boolean[n + 1];
        Arrays.fill(isUsed, false);
        dfs(n, k, 1);
        return res;
    }

    public static void dfs(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            path.add(i);
            dfs(n, k, i + 1);
            path.remove(path.size() - 1);
            isUsed[i] = false;

        }
    }

}
//    private static void dfs(int n, int k, int start) {
//        if (k == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = start; i <= n; i++) {
//            if (isUsed[i] == true) continue;
//
//            isUsed[i] = true;
//            path.add(i);
//            dfs(n, k - 1, i);
//            path.remove(path.size() - 1);
//            isUsed[i] = false;
//        }
//    }
