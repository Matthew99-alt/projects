package matvey.ApiWeather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class ApiWeather {
    public List<DailyForecast> getWeather() throws IOException {

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
        String weatherResponseJson = client.newCall(requestHttp).execute().body().string();
        weatherResponseJson = weatherResponseJson.substring(weatherResponseJson.indexOf("["));

        return weatherResponseToObject(weatherResponseJson);
    }

    private List<DailyForecast> weatherResponseToObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<>() {
        });
    }
}
