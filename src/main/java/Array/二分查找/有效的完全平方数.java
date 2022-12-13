package Array.二分查找;

/**
 * @author kai
 * @date 2022/2/28 下午1:57
 */
/*
给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
进阶：不要 使用任何内置的库函数，如  sqrt 。

输入：num = 16
输出：true

输入：num = 14
输出：false

 */
public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {//square==num找到返回true  不然false
                return true;
            }
        }
        return false;
    }
}
