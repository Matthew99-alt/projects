package matvey.ApiWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("Day")
    private Day day;

    public DailyForecast() {

    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "date='" + date + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
