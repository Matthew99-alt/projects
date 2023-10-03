package matvey.ApiWeather;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiWeather {

    public void getWeather() throws IOException {

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
                .addQueryParameter("apikey", "0d1tNZJPfzzT3qGokM18FGGxAUpt7hpj")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        // При необходимости указать заголовки
        Request requestHttp = new Request.Builder()
                .url(url)
                .build();

        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        System.out.println(jsonResponse);
    }
}
