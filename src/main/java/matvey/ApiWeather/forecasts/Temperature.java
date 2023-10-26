package matvey.ApiWeather.forecasts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @JsonProperty("Minimum")
    private Minimum min;

    @JsonProperty("Maximum")
    private Maximum max;


    public Temperature(@JsonProperty("Minimum") Minimum min,
                       @JsonProperty("Maximum") Maximum max) {
        this.min = min;
        this.max = max;
    }

    public Temperature() {
    }

    @Override
    public String toString() {
        return "Temparature " +
                "min= " + min +
                ", max= " + max;
    }
}
