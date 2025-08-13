package com.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    // expose "/" that return "Hello World!"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
