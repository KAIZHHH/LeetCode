package Test;

import lombok.var;

/**
 * @author kai
 * @date 2022/9/5 下午1:03
 */
public class TestVar {
    public static void main(String[] args) {
        var num1 = '1';
        var num2 = "2";
        var n1 = num1 + num2;
        System.out.println(n1);
        var num3 = "1";
        var num4 = "2";
        var n2 = num3 + num4;
        System.out.println(n2);
        var num5 = '1';
        var num6 = '2';
        var n3 = num1 + num2;
        System.out.println(n3);
    }
}
