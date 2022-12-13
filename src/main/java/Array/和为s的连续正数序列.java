package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/7/26 下午8:39
 */
/*
输入：target = 9
输出：[[2,3,4],[4,5]]

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
/*
*分析题意：我们用两个指针1和r表示当前枚举到的以1为起点到r的区间，sum表示[1，r]的区间和，由求和公式可0(1)求得为 sum=(1+r)*(r-1+1)/2，起始1=1，r=2。
*一共有三种情况：
*如果sum<target则说明指针r还可以向右拓展使得sum增大，此时指针r向右移动，即r+=1
*如果sum>target则说明以1为起点不存在一个下使得sum=target，此时要枚举下一个起点，指针1向右移动，即1+=1 *如果sum=target则说明我们找到了以1为起点得合法解[1，r]，我们需要将[1，r]的序列放进答案数组，且我们知道以 *1为起点的合法解最多只有一个，所以需要枚举下一个起点，指针1向右移动，即1+=1
终止条件即为1>=r的时候，这种情况的发生指针r移动到了(target。/2)+1的位置，导致1<r的时候区间和始终大于target。 这个1指针是左边界，而指针是右边界，有滑动窗口那味道了，只是这个窗口长度是动态变化的。
 */
public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(9);
        System.out.println(Arrays.deepToString(continuousSequence));
    }

    public static int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                // 记录结果
                res.add(arr);

                //进行下一个
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        //集合<一维数组> 转 二维数组
        return res.toArray(new int[res.size()][]);
    }
}
