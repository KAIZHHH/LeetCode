package 笔试.三六零;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {
    public final static int INFINITY = Integer.MAX_VALUE;
    public static Scanner sc = new Scanner(System.in);
    public static int n = sc.nextInt();
    public static int m = sc.nextInt();
    public static int dis[] = new int[n + 1];
    public static int arr[][] = new int[n + 1][n + 1];

    public static void main(String args[]) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INFINITY;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int value = sc.nextInt();
            arr[u][v] = value;
        }
        for (int i = 2; i <= n; i++) {
            dis[i] = INFINITY;
        }
        dis[1] = 0;
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(dis[i]);
        }
    }

    public static void dfs(int start) {
        Queue queue = new LinkedList();
        queue.add(start);
        while (queue.size() != 0) {
            int u = (int) queue.poll();
            for (int i = 2; i <= n; i++) {
                if (arr[u][i] != INFINITY) {
                    int v = i;
                    int sum = dis[u] + arr[u][v];
                    if (sum < dis[v]) {
                        dis[v] = sum;
                        queue.offer(v);
                    }
                }
            }
        }
    }
}
