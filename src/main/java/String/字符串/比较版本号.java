package String.字符串;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kai
 * @date 2022/11/29 下午6:48
 */
/*
返回规则如下：
如果 version1 > version2 返回 1，
如果 version1 < version2 返回 -1，

 */
public class 比较版本号 {
    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        int i = compareVersion(version1, version2);
        System.out.println(i);

    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
