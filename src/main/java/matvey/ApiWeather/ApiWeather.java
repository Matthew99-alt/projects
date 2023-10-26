package matvey.ApiWeather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import matvey.ApiWeather.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiWeather {

    //поля для конструкции запросов
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppInstance.getInstance().getApiKey();
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    //получаем погоду
    public void getWeather(Periods period) throws IOException {
        //находим ключ города
        String cityKey = detectCityKey();
        //создаём запрос
        OkHttpClient client = new OkHttpClient();

        String days = "";
        //определяем прогноз на 5 дней или на один
        if (period.equals(Periods.NOW)) {
            days = "1day";
        }
        if (period.equals(Periods.FIVE_DAYS)) {
            days = "5day";
        }
        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment("daily")
                .addPathSegment(days)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", "UUtI9t9n0mWWHbUUvcdMR0UIPF7SnXmS")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();
        Request requestHttp = new Request.Builder()
                .url(url)
                .build();
        //получаем json-строку
        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        //переводим строку в объект
        jsonToAnObject(jsonResponse);
    }

    //поиск ключа города
    public String detectCityKey() throws IOException {
        String selectedCity = AppInstance.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);
        //???
        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

    //метод для конвертации j-сона в объект
    private void jsonToAnObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weather = objectMapper.readValue(json, new TypeReference<>() {
        });
        System.out.println(weather.toString());
    }
}
