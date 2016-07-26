import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.TreeMap;

/**
 * @author Jari Van Melckebeke
 * @since 25.07.16
 */
public class Parser {
    public void parseJson(TreeMap<String, String> contents) {
        JSONArray array = new JSONArray();
        File res = new File("blog_berichten.json");
        if (!res.exists()) {
            try {
                res.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JSONParser parser = new JSONParser();
            try {
                array = (JSONArray) parser.parse(new FileReader(res));
                System.out.println(array);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fr = new FileWriter(res);
            BufferedWriter br = new BufferedWriter(fr);
            JSONObject object = new JSONObject();
            object.putAll(contents);
            System.out.println(contents);
            array.add(object);
            String json = array.toJSONString();
            System.out.println(json);
            br.write(json);
            br.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
