package com.bootcamp.assignment10.spoonacularApp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class SpoonacularController {
    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("timeFrame", "week")
                .queryParam("apiKey", "8310b651802f4ab2920506d98685913d")
                .queryParam("targetCalories", Integer.parseInt(numCalories))
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();
        ResponseEntity<WeekResponse> responseEntity = restTemplate.getForEntity(uri, WeekResponse.class);
        return responseEntity;
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                                        .queryParam("timeFrame", "day")
                                        .queryParam("apiKey", "8310b651802f4ab2920506d98685913d")
                                        .queryParam("targetCalories", Integer.parseInt(numCalories))
                                        .queryParam("diet", diet)
                                        .queryParam("exclude", exclusions)
                                        .build()
                                        .toUri();
        ResponseEntity<DayResponse> responseEntity = restTemplate.getForEntity(uri, DayResponse.class);
        return responseEntity;


    }
}
