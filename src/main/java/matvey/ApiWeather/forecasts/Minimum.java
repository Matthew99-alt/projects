package matvey.ApiWeather.forecasts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Minimum {
    @JsonProperty("Value")
    double value;

    public Minimum(@JsonProperty("Value")
                   double value){
        this.value = value;
    }

    public Minimum(){}

    @Override
    public String toString() {
        return "Minimum " +
                "value= " + value;
    }
}
