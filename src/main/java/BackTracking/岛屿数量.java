package BackTracking;

/**
 * @author kai
 * @date 2022/3/15 下午8:12
 */
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 */
public class 岛屿数量 {
    static int n;
    static int m;

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int i = numIslands(grid);
        System.out.println(i);
    }

    public static int numIslands(char[][] grid) {
        n = grid.length;//row行
        m = grid[0].length;//col列
        int res = 0;//岛屿数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    //记录
                    res++;
                    //再将周围的1归0
                    dfs(grid, i, j);
                }
            }

        }
        return res;
    }

    private static void dfs(char[][] grid, int i, int j) {
        //递归退出条件：超出界限/grid[i][j] == '0'
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;

        //先自己归0
        grid[i][j] = '0';
        //往上下左右扫描扫描
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
