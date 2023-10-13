package matvey.ApiWeather;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiWeather apiWeather = new ApiWeather();
        List<DailyForecast> weather = apiWeather.getWeather();
        System.out.println(weather.toString());
    }
}
