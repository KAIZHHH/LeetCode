package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/1/19 上午12:56
 */
/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果 可以变为  1，那么这个数就是快乐数：        return n == 1;
如果 n 是快乐数就返回 true ；不是，则返回 false 。

输入：n = 19
输出：true
解释：
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
示例 2：

输入：n = 2
输出：false
 */
public class 快乐数 {
    public static void main(String[] args) {
        boolean happy = isHappy(1);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        //SET集合记录不重复，一重复就退出
        Set<Integer> record = new HashSet<>();
        while (!record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
            System.out.println(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {//有十位 才能求余平方
            int temp = n % 10;//取余数：个位
            res += temp * temp;//res累加
            n = n / 10;//取十位
        }
        return res;
    }


//    public static int getNext(int n) {
//        int totalSum = 0;
//        while (n > 0) {
//            int d = n % 10;
//            n = n / 10;
//            totalSum += d * d;
//        }
//        return totalSum;
//    }
//
//    public static boolean isHappy1(int n) {
//        int slowRunner = n;
//        int fastRunner = getNext(n);
//        while (fastRunner != 1 && slowRunner != fastRunner) {
//            slowRunner = getNext(slowRunner);
//            fastRunner = getNext(getNext(fastRunner));
//        }
//        return fastRunner == 1;
//    }

}

