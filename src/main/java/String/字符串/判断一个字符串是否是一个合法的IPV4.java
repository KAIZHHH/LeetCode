package String.字符串;

/**
 * @author kai
 * @date 2022/7/28 下午10:15
 */
public class 判断一个字符串是否是一个合法的IPV4 {
    public static void main(String[] args) {
        String str = "10.10.1111.1";
        boolean ipLegal = isIpLegal(str);
        System.out.println(ipLegal);
    }

    public static boolean isIpLegal(String str) {
        //1.检查ip是否为空
        if (str == null) return false;
        //2.检查ip长度，最短为x.x.x.x(7位),最长为xxx.xxx.xxx.xxx(15位)
        if (str.length() < 7 || str.length() > 15) return false;
        //3.判断字符串首末字符是"."，则为非法
        if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') return false;

        //4.按“.”分割字符串，判断分割出来的个数，如果不是4个，则为非法字符
        String arr[] = str.split("\\.");
        if (arr.length != 4) return false;

        //5.对分割出来的每个字符串进行单独判断 A.B.C.D
        for (int i = 0; i < arr.length; i++) {
            //每个字符以‘0’开头为非法
            if (arr[i].length() > 1 && arr[i].charAt(0) == '0') return false;

            //对每个字符串进行逐一判断，如果不是数字 是字符 或者非法
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9') return false;
            }
        }

//A.B.C.D
        //对拆分的每一个字符串进行转化成数字，并判断是否在0-255
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);
            if (i == 0) {
                // 1<= temp <=255：return true
                if (temp < 1 || temp > 255) return false;
            } else {
                // 0<= temp <=255：return true
                if (temp < 0 || temp > 255) return false;
            }
        }
        return true;
    }

    //判断字符是否是IP
    public boolean isCorrectIp1(String ipString) {
        //1、判断是否是7-15位之间（0.0.0.0-255.255.255.255.255）
        if (ipString.length() < 7 || ipString.length() > 15) {
            return false;
        }
        //2、判断是否能以小数点分成四段
        String[] ipArray = ipString.split("\\.");
        if (ipArray.length != 4) {
            return false;
        }
        for (int i = 0; i < ipArray.length; i++) {
            //3、判断每段是否都是数字
            try {
                int number = Integer.parseInt(ipArray[i]);
                //4.判断每段数字是否都在0-255之间
                if (number < 0 || number > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    //利用正则表达式判断字符是否为IP
    public boolean isCorrectIp2(String ipString) {
        String ipRegex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";    //IP地址的正则表达式
        //如果前三项判断都满足，就判断每段数字是否都位于0-255之间
        if (ipString.matches(ipRegex)) {
            String[] ipArray = ipString.split("\\.");
            for (int i = 0; i < ipArray.length; i++) {
                int number = Integer.parseInt(ipArray[i]);
                //4.判断每段数字是否都在0-255之间
                if (number < 0 || number > 255) {
                    return false;
                }
            }
            return true;
        } else {
            return false;    //如果与正则表达式不匹配，则返回false
        }
    }
}

