package by.bsu.task2.util;

import com.rabbitmq.client.Channel;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Mikhail on 03.11.2017.
 */
public class MessageThread extends Thread {
    private static final String URL = "https://lambdatask.azurewebsites.net/api/HttpTriggerJS1?code=Wv1rIV/o3vKopz6yKSiX0pSxAlqCJRpNs3aa6VgLEoGxCVd4D2gd4A==";
    private Channel channel;
    private String email;
    private long tag;

    public MessageThread(Channel channel, String email, long tag) {
        this.channel = channel;
        this.email = email;
        this.tag = tag;
    }

    @Override
    public void run() {
        try {
            channel.basicAck(tag, false);
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(URL);
            post.setHeader("User-Agent", "Mozilla/5.0");
            post.setHeader("Content-Type", "application/json");
            JSONObject obj = new JSONObject();
            obj.put("email", email);
            StringEntity urlParameters = new StringEntity(obj.toString());
            post.setEntity(urlParameters);
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Util.responseToFile(result.toString(), email);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}