package BackTracking.剪枝法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/5/10 下午8:05
 */
/*
定义(n,start)，剪枝剪掉之前用过的                [1,2,3,4]
                                  |       |            |           |
                                 1        2            3           4
                             | | | |   | | | |    |  |  | |   |  |  |  |
                             1 2 3 4 （1）2 3 4  (1)(2) 3 4  (1)(2)(3) 4
 */


//[[1, 1], [1, 2], [1, 3], [1, 4], [2, 2], [2, 3], [2, 4], [3, 3], [3, 4], [4, 4]]
public class 定义start {

    static List<List<Integer>> result = new ArrayList<>();//[       ] result.add(path)
    static List<Integer> path = new ArrayList<>();// [ [],[] ]
    static Boolean[] isUsed;

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    private static void dfs(int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k - 1, i);
            path.remove(path.size() - 1);
        }
    }
}

