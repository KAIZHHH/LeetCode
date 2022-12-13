import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kai
 * @date 2022/2/19 上午12:11
 */
public class 接龙 {
    private static String[] words = new String[2000];

    public static void main(String[] args) {
        int m = 0;//words数组下标
        //读取文件至 words 字符串数组中
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("/Users/zhongdongzhao/Desktop/接龙.txt")));
            String linestr;//按行读取 将每次读取一行的结果赋值给linestr
            int i = 0;
            while ((linestr = br.readLine()) != null) {
                String patternStr = "0x.*";
                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(linestr);
                if (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    i++;
                    System.out.println(i + "."+linestr.substring(start, end));
                }
            }
            br.close();//关闭IO
        } catch (Exception e) {
            System.out.println("文件操作失败");
            e.printStackTrace();
        }

    }
}

