package BackTracking.剪枝法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/5/10 下午8:05
 */

/*
定义isUsed数组，剪枝剪掉自己                   [1,2,3,4]
                              |         |             |            |
                             1          2             3            4
                          | | | |   | |  | |     | |  |  |     | | |  |
                       （1）2 3 4   1（2）3 4     1 2 (3) 4     1 2 3 (4)
 */
//[[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 4], [3, 1], [3, 2], [3, 4], [4, 1], [4, 2], [4, 3]]




    /*  剪枝：path中存在的数据
                                            [1,2,3]
                              |                |                   |
                             1                 2                   3
                       |    |     |        |   |    |       |      |     |
                     （1）  2     3        1  （2）  3       1      2    (3)
                           |     |        |        |       |      |
                      (1)(2)3 (1)2(3) (1)(2)3   1(2)(3) (1)2(3) 1(2)(3)
                         123    132     213       231     312    321
     */
public class 定义isUsed数组 {

    static List<List<Integer>> result = new ArrayList<>();//[       ] result.add(path)
    static List<Integer> path = new ArrayList<>();// [ [],[] ]
    static Boolean[] isUsed;

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        isUsed = new Boolean[n + 1];
        Arrays.fill(isUsed, false);
        dfs(n, k);
        return result;
    }

    private static void dfs(int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isUsed[i] == true) continue;

            isUsed[i] = true;
            path.add(i);
            dfs(n, k - 1);
            path.remove(path.size() - 1);
            isUsed[i] = false;
        }
    }
}
