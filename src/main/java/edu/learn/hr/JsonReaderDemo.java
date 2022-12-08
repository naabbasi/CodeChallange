package edu.learn.hr;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JsonReaderDemo {
    public static void main(String[] args) {
        JsonReaderDemo jsonReaderDemo = new JsonReaderDemo();
        JSONObject jsonObject = jsonReaderDemo.getJsonObject();
        JSONArray jsonArrayObject = (JSONArray) jsonObject.get("data");

        if(jsonArrayObject instanceof JSONArray){
            Gson gson = new Gson();
            List<Movie> movieList = new ArrayList<>();
            for (Object object : jsonArrayObject) {
                //JSONObject jsonObjectItem = (JSONObject) object;
                Map<String, Object> jsonObjectMap = ((JSONObject) object).toMap();
                JsonElement jsonElement = gson.toJsonTree(jsonObjectMap);
                Movie movie = gson.fromJson(jsonElement, Movie.class);
                movieList.add(movie);
            }

            Collections.sort(movieList);
            System.out.println(movieList);
        }
    }

    private JSONObject getJsonObject() {
        String title = "Waterworld";
        try {
            URL url = new URL(String.format("https://jsonmock.hackerrank.com/api/movies/search/?Title=%s", title));
            String json = "";
            HttpResponse httpResponse = getHttpResponse(url);
            if (httpResponse.statusCode() == 200) {
                json = (String) httpResponse.body();
                System.out.println(json);
            }

            InputStream inputStream = getHttpURLConnectionInputStream(url);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] jsonByte = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(jsonByte);
            json = new String(jsonByte, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(json);
            return jsonObject;
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }

        return null;
    }

    private static InputStream getHttpURLConnectionInputStream(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        return inputStream;
    }

    private static HttpResponse getHttpResponse(URL url) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(url.toURI())
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse;
    }

    class Movie implements Comparable {
        private Long Year;
        private String imdbID;
        private String Title;

        public Movie() {
        }

        public Long getYear() {
            return Year;
        }

        public void setYear(Long year) {
            Year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Movie movie)) return false;
            return getYear().equals(movie.getYear()) && getImdbID().equals(movie.getImdbID()) && getTitle().equals(movie.getTitle());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getYear(), getImdbID(), getTitle());
        }

        @Override
        public int compareTo(Object o) {
            Movie movie = (Movie) o;
            return (int) (this.Year - movie.Year);
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "Year=" + Year +
                    ", imdbID='" + imdbID + '\'' +
                    ", Title='" + Title + '\'' +
                    '}';
        }
    }
}
