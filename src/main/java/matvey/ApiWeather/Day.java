package matvey.ApiWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

        @JsonProperty("IconPhrase")
        private String iconPhrase;

        public Day(String  iconPhrase){
                this.iconPhrase = iconPhrase;
        }

        public Day(){

        }

        @Override
        public String toString() {
                return "Day: "+"iconPhrase: "+iconPhrase;
        }
}
