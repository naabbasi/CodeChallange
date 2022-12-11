package edu.learn.hr.json_parser;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.json.*;

public class JsonParser {
    public static void main(String[] args) throws Exception {
        String urlString = "https://jsonmock.hackerrank.com/api/movies/search?Title=Waterworld";
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(urlString)).GET().build();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<Stream<String>> streamHttpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofLines());
        Stream<String> stringStream = streamHttpResponse.body();
        stringStream.forEach(result -> {
            System.out.println(result);
        });

        URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search?Title=Waterworld");
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpUrlConnection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] data = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(data);
        String json = new String(data, StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject);
        List<Map<String, Object>> jsonData = (List<Map<String, Object>>) jsonObject.get("data");
    }

    class Movie {
        private Long Year;
        private String imdbID;
        private String Title;
    }
}
