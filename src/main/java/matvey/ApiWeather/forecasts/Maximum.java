package matvey.ApiWeather.forecasts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Maximum {

    @JsonProperty("Value")
    double value;

    public Maximum(@JsonProperty("Value")
                   double value){
        this.value = value;
    }

    public Maximum(){}

    @Override
    public String toString() {
        return "Maximum " +
                "value=" + value;
    }
}
