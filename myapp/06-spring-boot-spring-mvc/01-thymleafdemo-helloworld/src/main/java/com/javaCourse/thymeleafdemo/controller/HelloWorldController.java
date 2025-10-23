package com.javaCourse.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

// create a controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


// create a controller method to process teh HTML form

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }


    // create a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormV2")
    public String shouting(HttpServletRequest request, Model model){

        // read the request from the HTML form
        String sName = request.getParameter("studentName");

        // convert the data to all caps
        sName = sName.toUpperCase();

        // create the message
        String result = "Hello! " + sName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String shoutingV2(@RequestParam("studentName") String sName, Model model){

        // convert the data to all caps
        sName = sName.toUpperCase();

        // create the message
        String result = "Hey " + sName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
