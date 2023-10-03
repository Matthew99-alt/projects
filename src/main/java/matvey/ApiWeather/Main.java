package matvey.ApiWeather;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiWeather weather = new ApiWeather();
        weather.getWeather();
    }
}
