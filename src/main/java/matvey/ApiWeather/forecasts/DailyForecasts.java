package matvey.ApiWeather.forecasts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("Temperature")
    private Temperature temperature;

    DailyForecasts(String date, Temperature temperature){
        this.date = date;
        this.temperature = temperature;
    }

    DailyForecasts(){
    }

    @Override
    public String toString() {
        return "DailyForecast " +
                "date= " + date + '\'' +
                ", temparature= " + temperature;
    }
}
