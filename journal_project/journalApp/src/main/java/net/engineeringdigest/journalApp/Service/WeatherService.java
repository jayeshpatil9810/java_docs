package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Constants.Placeholders;
import net.engineeringdigest.journalApp.api_response.WeatherResposne;
import net.engineeringdigest.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    //private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResposne getWeather(String city) {
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
        // First check raw JSON
        ResponseEntity<String> raw = restTemplate.exchange(finalAPI, HttpMethod.GET, null, String.class);
        System.out.println("API Raw Response: " + raw.getBody());

        // Then parse into your WeatherResposne
        ResponseEntity<WeatherResposne> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResposne.class);
        WeatherResposne body = response.getBody();
        System.out.println(body);
        return body;
    }
}
