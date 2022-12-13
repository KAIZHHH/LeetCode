package String;

/**
 * @author kai
 * @date 2022/4/24 下午4:16
 */
/*
输入:s = "abccccdd"
输出:7
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

输入:s = "a"
输出:1

输入:s = "bb"
输出: 2

求：可以构造字符串的最长回文串长度
思路：
1、定义arr[]数组：用来记录字符串中字符出现的次数
2、遍历arr[]数组：记录出现次数为奇数的次数
3、返回：判断是否奇数为0？0：总长度-奇数次数+1
 */
public class 最长回文串_哈希表_个数 {
    public static void main(String[] args) {
        String s = "abccccdd";
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    public static int longestPalindrome(String s) {
        int n = s.length();
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        //遍历arr[]数组 每个字符c的值
        for (int c : arr) {
            if (c % 2 != 0) {
                count++;//记录奇数的
            }
        }
        //字符出现的个数都是偶数 都为一对的话：直接返回长度
        //字符出现的个数有奇数 ：总长度-奇数+1
        return count == 0 ? n : n - count + 1;
    }
}
