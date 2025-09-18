package net.engineeringdigest.journalApp.api_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.connector.Request;

import javax.xml.stream.Location;
import java.util.List;

@Getter
@Setter
public class WeatherResposne {

    private Current current;

    @Getter
    @Setter
    public class Current{

        private int temperature;
        @JsonProperty("weather_description")
        private List<String> weatherDescriptions;

        private int feelslike;


    }
}







