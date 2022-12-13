package Test.String;

/**
 * @author kai
 * @date 2022/9/5 下午2:28
 */
public class T3 {
    public static void main(String[] args) {
        String s1 = "he" + "llo";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        StringBuffer s5 = new StringBuffer("hello");
        StringBuffer s6 = new StringBuffer("hello");
        String ss1="a"+new String("b");
        String ss2="b"+new String("a");
        System.out.println(ss1==ss2);
        System.out.println(ss1.equals(ss2));

//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s3 == s4);//
//        System.out.println(s3.equals(s4));//string重写了equals 比较内容
//        System.out.println(s5 == s6);
//        System.out.println(s5.equals(s6));
    }
}
