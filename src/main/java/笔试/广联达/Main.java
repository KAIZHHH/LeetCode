package 笔试.广联达;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/31 下午10:15
 */
/*
粒子实验
题目描述：
一些科学家在研究X粒子的特性，通常情况下，X粒子在经过加速装置后拥有的速度均为V，但是加热后，某些粒子的特性发生了变化，在相同情况下经过加速装置后拥有的速度变得大于V了（变化后的速度不一定相同），于是科学家们决定研究这些特别的粒子。
科学家们对n个粒子做了特殊处理，为其从1到n分别编号，为了找出是哪些粒子的特性发生了变化（导致速度变化），他们准备让这些粒子依次通过一段相同长度的距离，速度越高的粒子通过这段距离所需的时间越短，由于技术问题，只能检测到粒子发射顺序和到达终点的顺序（没有两个粒子同时被发射或同时到达），请你通过这些数据计算出至少有多少个粒子特性发生了变化（即速度大于通常情况）。

输入描述
第一行一个正整数n，表示粒子数量。
接下来一行包含n个正整数s1, s2,...... sn(1≤si≤n)，为按发射顺序给出的粒子编号，s1-sn为1-n的一个排列。
接下来一行包含n个正整数p1,P2 ,...... pn(1≤pi≤n)，为按到达终点顺序给出的粒子编号，p1-pn为1-n的一个排列。

输出描述
输出至少有多少个粒子特性发生了变化（即速度大于通常情况）

样例输入
5
5 4 3 2 1
1 5 3 4 2
样例输出
2

样例说明：编号为1的粒子最晚发射却最早到达，速度肯定大于通常情况，编号为3的粒子比编号为4的粒子更晚发射却比其更早到达，速度肯定大于通常情况，其余粒子均有可能速度未发生变化，因此至少有2个粒子速度大于通常情况。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int test = test(n, arr, arr1);
        System.out.println(test);
    }

    private static int test(int n, int[] arr, int[] arr1) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i + 1);
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map1.put(arr1[i], i + 1);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int i1 = arr1[i];
            int r1 = map.get(i1);
            int m1 = map1.get(i1);

            for (int j = i + 1; j < n; j++) {
                int i2 = arr1[j];
                int r2 = map.get(i2);
                int m2 = map1.get(i2);
                if (r1 > r2 && m1 < m2) {
                    sum++;
                    break;
                }
            }

        }
        return sum;
    }
}
