package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/17 下午10:03
 */
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] interval = {{1, 4}, {0, 4}};
        int[][] merge = merge(interval);
        System.out.println(Arrays.deepToString(merge));
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//升序

        int start = intervals[0][0];
        for (int i = 1; i < n; i++) {
            if (intervals[i - 1][1] < intervals[i][0]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        res.add(new int[]{start, intervals[n - 1][1]});
        int size = res.size();

        return res.toArray(new int[size][]);
    }
}
