package Greedy;

/**
 * @author kai
 * @date 2022/2/17 下午10:51
 */
/*
当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。

给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。

输入: n = 10
输出: 9
示例 2:

输入: n = 1234
输出: 1234
示例 3:

输入: n = 332
输出: 299

 */
public class 单调递增的数字 {

    public static void main(String[] args) {
        int i = monotoneIncreasingDigits(332);
        System.out.println(i);
    }

    public static int monotoneIncreasingDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        int start = Integer.MAX_VALUE;//start初始值设为最大值，这是为了防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {//后一位 < 前一位，前一位--
                chars[i - 1]--;
                start = i;
            }
        }

        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        //不能用chars.toString()
        String s = String.valueOf(chars);
        int i = Integer.parseInt(s);
        return i;
    }
}
