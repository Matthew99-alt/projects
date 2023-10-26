package matvey.ApiWeather.forecasts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {

    @JsonProperty("Text")
    private String text;

    public Headline(@JsonProperty("Text")
                    String text) {
        this.text = text;
    }

    public Headline() {
    }

    @Override
    public String toString() {
        return " Headline " +
                "text= " + text + '\'';
    }
}
