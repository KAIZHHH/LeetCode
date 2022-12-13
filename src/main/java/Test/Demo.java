package Test;

public class Demo {
    public static String sRet = "";
    public static void func(int i)
    {
        try
        {
            if (i%2==0)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            sRet += "0";
            return;
        }
        finally
        {
            sRet += "1";
        }
        sRet += "2";
    }
    public static void main(String[] args)
    {
        func(1);
        System.out.println(sRet);
    }
}
/*
try有异常 再走catch catch有return 先走finally 再走return（跳过了该方法以外的语句执行）
try有异常 再走catch catch有return 先走finally 再走return（跳过了该方法以外的语句执行）

 */
