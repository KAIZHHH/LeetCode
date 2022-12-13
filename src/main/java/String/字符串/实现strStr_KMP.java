package String.字符串;

/**
 * @author kai
 * @date 2022/7/28 下午10:44
 */

/*
输入：haystack = "hello", needle = "ll"
输出：2
示例 2：

输入：haystack = "aaaaa", needle = "bba"
输出：-1
 */
public class 实现strStr_KMP {
    public static void main(String[] args) {
        String haystack = "hellollon";
        String needle = "llon";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int next[] = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    public static void getNext(int[] next, String s) {
        //j：前缀末尾的位置 and 包括i前子串最长相等长度
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            //j>0才可以回退：回退到j-1的next值的下标处
            //while 需要不停往前回退
            while (j > 0 && s.charAt(i) != s.charAt(j)) {//当遇见冲突 不相等时
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

}
