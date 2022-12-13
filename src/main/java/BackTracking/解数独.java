package BackTracking;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/13 下午11:19
 */
/*
编写一个程序，通过填充空格来解决数独问题。

数独的解法需 遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。


输入：board = [['5','3','.','.','7','.','.','.','.'],
              ['6','.','.','1','9','5','.','.','.'],
              ['.','9','8','.','.','.','.','6','.'],
              ['8','.','.','.','6','.','.','.','3'],
              ['4','.','.','8','.','3','.','.','1'],
              ['7','.','.','.','2','.','.','.','6'],
              ['.','6','.','.','.','.','2','8','.'],
              ['.','.','.','4','1','9','.','.','5'],
              ['.','.','.','.','8','.','.','7','9']]
        输出：[['5','3','4','6','7','8','9','1','2'],
              ['6','7','2','1','9','5','3','4','8'],
              ['1','9','8','3','4','2','5','6','7'],
              ['8','5','9','7','6','1','4','2','3'],
              ['4','2','6','8','5','3','7','9','1'],
              ['7','1','3','9','2','4','8','5','6'],
              ['9','6','1','5','3','7','2','8','4'],
              ['2','8','7','4','1','9','6','3','5'],
              ['3','4','5','2','8','6','1','7','9']]
解释：输入的数独如上图所示，唯一有效的解决方案如下所示：

 */
public class 解数独 {


    public static void main(String[] args) {
char[][] board={{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        dfs(board);
    }

    private static boolean dfs(char[][] board) {
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++) { // 遍历行
            for (int j = 0; j < 9; j++) { // 遍历列
                //不需要填【board[i][j]!= '.'】
                if (board[i][j] != '.') {
                    continue;
                }
                //需要填【board[i][j] == '.'】
                for (char k = '1'; k <= '9'; k++) { // (i, j) 这个位置放k是否合适
                    //判断是否合法，放入k
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        //放入k后递归调用 看看是否有重复 没有则返回true
                        if (dfs(board)) return true;
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了都不行(有重复)，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     */
    private static boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            // 同行是否重复
            if (board[row][i] == val) return false;//确定行数改变列数
            // 同列是否重复
            if (board[i][col] == val) return false;//确定列数改变行数
            //九个九宫格，判断每个九宫格里所有元素不重复
            //board[3][5]==  3/
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) return false;
        }
        return true;
    }
}
