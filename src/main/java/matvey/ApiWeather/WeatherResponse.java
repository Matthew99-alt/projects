package matvey.ApiWeather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import matvey.ApiWeather.forecasts.DailyForecasts;
import matvey.ApiWeather.forecasts.Headline;

import java.sql.Date;
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
                           @JsonProperty("DailyForecasts") DailyForecasts[] dailyForecast) {
        this.headline = headline;
        this.dailyForecast = dailyForecast;
    }

    public String getHeadlineText() {
        return headline.getText();
    }

    public int getDailyForecastsLength() {
        return dailyForecast.length;
    }

    public String getDailyForecastsDate(int i) {
        return dailyForecast[i].getDate();
    }

    public double getDailyForecastsMin(int i) {
        return dailyForecast[i].getTemperatureMin();
    }

    public double getDailyForecastsMax(int i) {
        return dailyForecast[i].getTemperatureMax();
    }

    @Override
    public String toString() {
        return "WeatherResponse" + headline +
                ", " + Arrays.toString(dailyForecast);
    }
}
