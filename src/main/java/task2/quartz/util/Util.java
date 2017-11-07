package task2.quartz.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mikhail on 06.11.2017.
 */
@SuppressWarnings("ALL")
public class Util {

    public static final String NAME = "guest";
    public static final String PASSWORD = "guest";
    public static final String VHOST = "/";
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 5672;
    public static final String EXCHANGENAME = "myExchange";
    public static final String ROUTINGKEY = "testRoute";
    private static final String FILE = "C:\\Users\\Mikhail\\Documents\\emails.json";

    static void responseToFile(String response, String email) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        JSONObject res = (JSONObject) parser.parse(response);
        Object obj = parser.parse(new FileReader(FILE));

        JSONArray results = (JSONArray) obj;
        JSONObject object = new JSONObject();
        object.put(email, res.get("isEmailValid"));
        results.add(object);
        System.out.println(results);
        try (FileWriter file = new FileWriter(FILE)) {
            file.write(results.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
