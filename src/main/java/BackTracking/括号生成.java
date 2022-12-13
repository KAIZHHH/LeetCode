package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/5/22 下午3:18
 */
/*
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

输入：n = 1
输出：["()"]
 */
public class 括号生成 {
    static List<String> res = new ArrayList();


    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }

    private static void dfs(String s, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        //剪枝：一旦(次数大于n 就退出  一旦(>)【一开始先是)再是(】 就退出
        if (left > n || left < right) return;
        dfs(s + "(", left + 1, right, n);
        dfs(s + ")", left, right + 1, n);
    }

}
