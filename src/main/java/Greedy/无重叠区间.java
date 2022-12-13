package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kai
 * @date 2022/2/17 下午6:40
 */
/*
给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。

输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: intervals = [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: intervals = [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        //                    A  B
        int[][] intervals = {{1, 3}, {2, 4}, {3, 4}, {6, 7}};
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                //  B中没有相等的
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);//B升序
                } else {
                    //  B中有相等的
                    return Integer.compare(a[0], b[0]);//A升序
                }
            }
        });

        int count = 1;
        int edge = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (edge <= intervals[i][0]) {//记录正常的(不相交的)
                count++;
                edge = intervals[i][1];//赋值给下一个去比较
            }
        }
        return intervals.length - count;//总-不正常的
    }
}
