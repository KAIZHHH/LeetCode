package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/13 下午6:10
 */
/*
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

输入：n = 4
输出：[[".Q..",
       "...Q",
       "Q...",
       "..Q."],
      ["..Q.",
       "Q...",
       "...Q",
       ".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。

输入：n = 1
输出：[["Q"]]
 */
public class N皇后 {
    static List<List<String>> result = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        int i = solveNQueens(4);
        System.out.println(i);
    }

    public static int solveNQueens(int n) {
        dfs(0, n);
        return result.size();
    }

    /**
     * @param count 已经放了多少个棋子
     * @param n     需要放多少个棋子
     */
    public static void dfs(int count, int n) {
        //相等：棋子放够了
        if (count == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        //确定'Q'的行：递增count  默认count几就是第几行
        //确定'Q'的列：遍历i
        for (int i = 0; i < n; i++) {
            //判断当前列i是否符合放'Q'
            if (!isValid(count, i, n)) {
                continue;
            }

            //确定'Q'的列:i
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == j) {//填充Q元素 和其他元素
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            path.add(sb.toString());
            //已经放了第一个了所以count+1
            dfs(count + 1, n);//第一行 第二行
            path.remove(path.size() - 1);

        }
    }

    //新增的'Q'：检查同一列是否重复、检查45度对角线是否重复、检查135度对角线是否重复


    public static boolean isValid(int row, int col, int n) {
        // 遍历之前的每一个'R'(<row 一个row放一个R)所在的列 和新的'R'是否重复
        for (int i = 0; i < row; i++) {
            //拿到行
            String s = path.get(i);
            //如果存在 当前行'Q'的所在的列 是否重复
            if (s.charAt(col) == 'Q') return false;
        }
        // 检查45度对角线是否重复
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            //遍历拿到之前的行
            String s = path.get(i);
            //排除掉 当前行中'Q'不能存在的列数
            if (s.charAt(j) == 'Q') return false;
        }
        // 检查135度对角线是否重复
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            //遍历拿到之前的行
            String s = path.get(i);
            //排除掉 当前行中'Q'不能存在的列数
            if (s.charAt(j) == 'Q') return false;
        }
        return true;
    }
}
