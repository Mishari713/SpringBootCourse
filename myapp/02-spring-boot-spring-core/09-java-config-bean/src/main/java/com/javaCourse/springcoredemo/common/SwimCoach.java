package com.javaCourse.springcoredemo.common;

import org.springframework.context.annotation.Bean;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    @Bean
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
