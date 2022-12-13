package String;

/**
 * @author kai
 * @date 2022/4/25 下午9:37
 */
/*
s = "abc"   解释：三个回文子串: "a", "b", "c"
输出：3

输入：s = "aaa"    解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
输出：6

求：该字符串中 满足的回文子串 所有次数
思路：
1、遍历所有字符 作为奇数调用：spread(s,i,i) 作为偶数调用：spread(s,i,i+1)
2、spread()返回满足回文子串的个数
3、res=spread(s,i,i)+spread(s,i,i+1)
 */
public class 回文子串_双指针_个数 {
    public static void main(String[] args) {
        int abc = countSubstrings("aba");
        System.out.println(abc);
    }

    //中心扩散
    public static int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //回文子串为奇数：1、3、5
            res += spread(i, i, s);
            //回文子串为偶数：2、4、6
            res += spread(i, i + 1, s);
        }
        return res;
    }

    private static int spread(int l, int r, String s) {
        int c = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 返回的是 符合 回文串 的子串数 不是计算长度
            c++;
            l--;
            r++;
        }
        return c;
    }

}

