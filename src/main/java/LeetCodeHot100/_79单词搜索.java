package LeetCodeHot100;

/**
 * @author kai
 * @date 2022/7/12 下午11:25
 */
/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false
 */
public class _79单词搜索 {
    int m;//board.length
    int n;//board[0].length
    int w;//word长度

    boolean visited[][];//规定：同一个单元格内的字母不允许重复使用
    char[] words;

    char[][] board;
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        boolean exist = new _79单词搜索().exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.w = word.length();
        this.board = board;
        this.visited = new boolean[m][n];
        this.words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //0 is the index of the chars of the string word
                if (search(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(int i, int j, int k) {
        //遍历到 超过word最大长度 证明 存在 返回true
        if (k >= w) {
            return true;
        }
        //正常： i [0,m)    j [0,n)            当前遍历的元素是否和words[k]相同   判断该元素是否走过
        if (i < 0 || j < 0 || i >= m || j >= n || words[k] != board[i][j] || visited[i][j]) {
            return false;
        }
        //访问过 标记 true
        visited[i][j] = true;
        //有一个为true  都为 true
        boolean res = search(i + 1, j, k + 1) ||
                search(i, j + 1, k + 1) ||
                search(i - 1, j, k + 1) ||
                search(i, j - 1, k + 1);

        //访问完 标记 false
        visited[i][j] = false;
        return res;
    }
}
