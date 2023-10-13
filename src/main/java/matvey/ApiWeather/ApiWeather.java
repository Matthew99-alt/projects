package matvey.ApiWeather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiWeather {
    public void getWeather() throws IOException, JsonProcessingException {

        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("474212_PC")
                .addQueryParameter("apikey", "UUtI9t9n0mWWHbUUvcdMR0UIPF7SnXmS")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        // При необходимости указать заголовки
        Request requestHttp = new Request.Builder()
                .url(url)
                .build();
        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        jsonResponse = jsonResponse.substring(jsonResponse.indexOf("["));
        jsonToAnObject(jsonResponse);
    }
    public static void jsonToAnObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<DailyForecast> weather = objectMapper.readValue(json, new TypeReference<List<DailyForecast>>(){});
        System.out.println(weather.toString());
    }
}
