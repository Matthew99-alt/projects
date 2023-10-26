package matvey.ApiWeather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import matvey.ApiWeather.forecasts.DailyForecasts;
import matvey.ApiWeather.forecasts.Headline;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("Headline")
    private Headline headline;

    @JsonProperty("DailyForecasts")
    private DailyForecasts[] dailyForecast;

    //создаём объект из json-строки
    @JsonCreator
    public WeatherResponse(@JsonProperty("Headline") Headline headline,
                           @JsonProperty("DailyForecasts") DailyForecasts[] dailyForecast){
        this.headline = headline;
        this.dailyForecast = dailyForecast;
    }

    @Override
    public String toString() {
        return "WeatherResponse" + headline +
                ", " + Arrays.toString(dailyForecast);
    }
}
