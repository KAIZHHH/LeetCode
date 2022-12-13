package technology;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FileTest {
    public static void main(String[] args) {

        String s = readJsonData("C:\\Users\\huangkai.zhong\\Desktop\\api-docs.json");
        JSONObject object = JSONObject.parseObject(s);

        //拿到原有的paths进行处理
        JSONObject pathObject = object.getJSONObject("paths");
        Iterator<Map.Entry<String, Object>> iter = pathObject.entrySet().iterator();
        JSONObject newPath = new JSONObject();

        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            JSONObject value = (JSONObject)entry.getValue();
            JSONObject newValue = new JSONObject();

            if (!key.startsWith("/api/v1/")) {
                newPath.put(key, newValue);

                Set<String> keySet = value.keySet();
                for (String item : keySet) {
                    if ("get".equalsIgnoreCase(item) || "post".equalsIgnoreCase(item)) {
                        newValue.put(item, value.getJSONObject(item));
                    }
                }
            }
        }
        object.put("paths", newPath);

        writeFile("C:\\Users\\huangkai.zhong\\Desktop\\new.json", object.toJSONString());

    }

    public static String readJsonData(String pactFile) {

        StringBuffer strbuffer = new StringBuffer();
        File myFile = new File(pactFile);
        try {
            FileInputStream fis = new FileInputStream(pactFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return strbuffer.toString();

    }

    public static boolean writeFile(String filePath, String sets) {
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out = new PrintWriter(fw);
            out.write(sets);
            out.println();
            fw.close();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
