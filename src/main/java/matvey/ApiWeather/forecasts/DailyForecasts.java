package matvey.ApiWeather.forecasts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

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

    public double getTemperatureMin() {
        return temperature.getMin().getValue();
    }

    public double getTemperatureMax() {
        return temperature.getMax().getValue();
    }

    public String getDate(){
        return date;
    }

    @Override
    public String toString() {
        return "DailyForecast " +
                "date= " + date + '\'' +
                ", temparature= " + temperature;
    }
}
