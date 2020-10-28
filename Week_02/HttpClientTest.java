package Week_02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClientTest {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws Exception {
        HttpClientTest httpClientTest = new HttpClientTest();
        String run = httpClientTest.run("http://127.0.0.1:8088/api/hello");
        System.out.println(run);
    }
}
