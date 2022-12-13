package Test.String;

/**
 * @author kai
 * @date 2022/9/5 下午1:21
 */
public class T1 {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        //比较内容
        System.out.println(s1.equals(s2));//自动重写了 比较内容  true
        System.out.println(s1.equals(s3));//自动重写了 比较内容  true
        //比较地址
        System.out.println(s1 == s2);//true  s1 s2指向常量池
        System.out.println(s1 == s3);//false s1指向常量池 s3指向堆

    }
}
