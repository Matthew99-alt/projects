package matvey.ApiWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

    @JsonProperty("IconPhrase")
    private String iconPhrase;

    //TODO:
    // JsonCreator - вспомни как работает
    // в целом повтори "нюансы как работает ObjectMapper (урок с примерами Student, Car, Person…)"
    public Day() {

    }

    @Override
    public String toString() {
        return "Day: " + "iconPhrase: " + iconPhrase;
    }
}
