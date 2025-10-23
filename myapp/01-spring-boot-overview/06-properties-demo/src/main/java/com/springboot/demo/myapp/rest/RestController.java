package com.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    // Inject properties for: couch.name and team.name

    @Value("${couch.name}")
    private String couchName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Couch: " + couchName + ", Team: " + teamName;
    }

    // expose "/" that return "Hello World!"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }


    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5K";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }
}
