package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/12 上午11:11
 */
/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]

输入：s = "0000"
输出：["0.0.0.0"]

输入：s = "1111"
输出：["1.1.1.1"]

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class 复原IP地址 {
    static List<String> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("010010");
        System.out.println(strings);

    }

    public static List<String> restoreIpAddresses(String s) {
        dfs(s, 0);
        return result;
    }

    public static void dfs(String s, int start) {
        if (s.length() == 0 && start == 4) {
            result.add(new StringBuilder(sb).toString());
            return;
        }

        //for遍历为截取次数  s="101 1023"不能拆成1.0.1.1023  要求s每个组的长度不能超过三位数
        for (int i = 0; i < s.length() && i <= 2; i++) {//0.1.2 三位数
            //i != 0：不是起始  但值为0 则结束 例如："1.01.01" 错误的
            if (i != 0 && s.charAt(0) == '0') {//s是变化的截取长度
                break;
            }
            //不为0情况
            String sub = s.substring(0, i + 1);//截取：[0...i]
            if (Integer.parseInt(sub) <= 255) {//string"123"转成int:123
                if (sb.length() != 0) {
                    sub = '.' + sub;
                }
                sb.append(sub);
                //   将剩余的 s 传进去继续调用
                dfs(s.substring(i + 1), start + 1);
                sb.delete(sb.length() - sub.length(), sb.length());
            }
        }
    }
}
