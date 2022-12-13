package String.字符串;

public class IP整数转换 {

    //将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
    public static long ipToLong(String stringIP) {
        long[] ip = new long[4];
        //先找到IP地址字符串中.的位置
        int p1 = stringIP.indexOf(".");
        int p2 = stringIP.indexOf(".", p1 + 1);
        int p3 = stringIP.indexOf(".", p2 + 1);
        //将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(stringIP.substring(0, p1));
        ip[1] = Long.parseLong(stringIP.substring(p1 + 1, p2));
        ip[2] = Long.parseLong(stringIP.substring(p2 + 1, p3));
        ip[3] = Long.parseLong(stringIP.substring(p3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    //将十进制整数形式转换成127.0.0.1形式的ip地址
    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        //直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        //将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        //将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        //将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    public static void main(String[] args) {
        String ipStr = "192.168.0.1";
        long longIp = IP整数转换.ipToLong(ipStr);
        System.out.println("192.168.0.1 的整数形式为：" + longIp);
        System.out.println("整数" + longIp + "转化成字符串IP地址："
                + IP整数转换.longToIP(longIp));
        //ip地址转化成二进制形式输出
        System.out.println("192.168.0.1 的二进制形式为：" + Long.toBinaryString(longIp));

    }
}
