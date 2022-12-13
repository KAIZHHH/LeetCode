package Test;

public class TestTryCatch1 {
    public int add(int a,int b){
         try {
             return a+b;
         }
        catch (Exception e) {
            System.out.println("catch语句块");
         }
         finally{
             System.out.println("finally语句块");
         }
         return 0;
    }
     public static void main(String argv[]){
         TestTryCatch1 testTryCatch1 =new TestTryCatch1();
         System.out.println("和是："+ testTryCatch1.add(9, 34));
     }


}
