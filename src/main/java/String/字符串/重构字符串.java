package String.字符串;

/**
 * @author kai
 * @date 2022/8/7 下午8:54
 */
/*
给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。

输入: s = "aab"
输出: "aba"

输入: s = "aaab"
输出: ""
 */
public class 重构字符串 {
    public static void main(String[] args) {
        String s = "vvvlo";
        String string = reorganizeString1(s);
        System.out.println(string);
    }

    public static String reorganizeString1(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[maxIndex] < count[i]) {
                maxIndex = i;
            }
        }
        if (count[maxIndex] > (n + 1) / 2) return "";

        char[] res = new char[n];
        int i = 0;
        while (count[maxIndex]-- > 0) {
            res[i] = (char) ('a' + maxIndex);
            i += 2;
        }
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                if (i >= n) i = 1;
                res[i] = (char) ('a' + j);
                i += 2;
            }
        }
        return String.valueOf(res);

    }

    public static String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int[] count = new int[26];
        //计数
        for (char c : arr) {
            count[c - 'a']++;
        }
        //统计次数最多的字符
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }

        //判断次数最多的字符 是否超过 一半 (n+1) / 2 同时考虑了 奇数 和 偶数 情况
        //超过则 证明 一定会有 相邻
        if (count[maxIndex] > (n + 1) / 2) return "";

        //先放max字符 散列放
        char[] res = new char[n];
        int i = 0;
        while (count[maxIndex]-- > 0) {
            res[i] = (char) ('a' + maxIndex);
            i += 2;
        }

        //放完在放其他字符
        //j:遍历其余元素的
        //i:返回数组的元素的插入位置
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                if (i >= n) i = 1; // 偶数位置用完了，放到奇数位置
                res[i] = (char) ('a' + j);
                i += 2;
            }
        }

        return String.valueOf(res);
    }
}
